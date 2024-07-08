package me.tolek.modules.settings;

import me.tolek.modules.settings.base.BooleanSetting;
import me.tolek.modules.settings.base.MflpSetting;
import me.tolek.util.InstancedValues;
import me.tolek.util.MflpUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class AutoWelcome extends BooleanSetting {

    public AutoWelcome() {
        super("Auto welcome", false, "Automatically says welcome! when a new person joins synergy");
    }

    @Override
    public void run() {
        this.setState(!this.getState());
        // if (this.getState == false) then do something
    }

    @Override
    public void refresh() {
        if (this.getState() && MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.networkHandler.sendChatMessage(MflpSettingsList.getInstance().WELCOME_MESSAGE.getState());
        }
    }

    public void executeAutoWelcome(Text message, MflpSetting setting, String playerName) {
        InstancedValues iv = InstancedValues.getInstance();
        if (!message.getString().contains(playerName)) {
            if (message.getString().contains("Welcome") && message.getString().contains(" to Synergy!")) {
                if (!MflpUtil.isFakeMessage(message)) {
                    if (iv.timeSinceLastInputInMils / 1000 < 30 && !iv.isAfk) {
                        setting.refresh();
                        iv.pauseWelcomeBack = true;
                    }
                }
            }
        }
    }

}
