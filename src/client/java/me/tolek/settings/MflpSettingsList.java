package me.tolek.settings;

import me.tolek.settings.base.BooleanSetting;
import me.tolek.settings.base.MflpSetting;

import java.util.ArrayList;

public class MflpSettingsList {

    private static MflpSettingsList instance;


    public AutoWelcomeBack AUTO_WELCOME_BACK = new AutoWelcomeBack();
    public AutoWBWhitelist AUTO_WB_WHITELIST = new AutoWBWhitelist();
    public WelcomeBackWhitelist WB_WHITELIST = new WelcomeBackWhitelist();
    public AutoWBBlacklist AUTO_WB_BLACKLIST = new AutoWBBlacklist();
    public WelcomeBackBlacklist WB_BLACKLIST = new WelcomeBackBlacklist();

    private MflpSettingsList() {

    }

    public static MflpSettingsList getInstance() {
        if (instance == null) MflpSettingsList.instance = new MflpSettingsList();
        return instance;
    }

    public ArrayList<MflpSetting> getSettings() {
        ArrayList<MflpSetting> settings = new ArrayList<>();
        settings.add(AUTO_WELCOME_BACK);
        /*settings.add(AUTO_WB_WHITELIST);
        settings.add(AUTO_WB_BLACKLIST);
        settings.add(WB_WHITELIST);
        settings.add(WB_BLACKLIST);*/
        return settings;
    }

}
