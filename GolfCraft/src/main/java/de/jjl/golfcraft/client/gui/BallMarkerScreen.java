package de.jjl.golfcraft.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.jjl.golfcraft.entity.Golfball;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class BallMarkerScreen extends Screen
{
	protected TextFieldWidget nameTextField;
	
	protected Button doneButton;
	
	protected Button cancelButton;

	private Golfball golfball;

	public BallMarkerScreen(Golfball golfball)
	{
		super(NarratorChatListener.EMPTY);
		this.golfball = golfball;
	}

	protected void init()
	{
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.doneButton = addButton(new Button(this.width / 2 - 4 - 150, this.height / 4 + 120 + 12, 150, 20,
				new StringTextComponent("Done"), btn -> onDoneButtonPressed()));
		this.cancelButton = this.addButton(new Button(this.width / 2 + 4, this.height / 4 + 120 + 12, 150, 20,
				new StringTextComponent("Cancel"), btn -> onClose()));

		nameTextField = new TextFieldWidget(this.font, this.width / 2 - 150, 50, 300, 20,
				new StringTextComponent("advMode.command"));
		;

		this.nameTextField.setMaxStringLength(32500);
		this.children.add(this.nameTextField);

		this.setFocusedDefault(this.nameTextField);
		this.nameTextField.setFocused2(true);
	}

	@Override
	public void render(MatrixStack mx, int p_render_1_, int p_render_2_, float p_render_3_)
	{
		super.render(mx, p_render_1_, p_render_2_, p_render_3_);

		nameTextField.render(mx, p_render_1_, p_render_2_, p_render_3_);
	}

	public void tick()
	{
		nameTextField.tick();
	}

	public void updateGui()
	{
	}

	protected void onDoneButtonPressed()
	{
		String name = nameTextField.getText();
		nameBall(name);

		this.getMinecraft().displayGuiScreen((Screen) null);
	}

	private void nameBall(String name)
	{
		golfball.setCustomName(new StringTextComponent(name));
	}
}
