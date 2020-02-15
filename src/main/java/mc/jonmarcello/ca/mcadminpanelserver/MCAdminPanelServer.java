package mc.jonmarcello.ca.mcadminpanelserver;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class MCAdminPanelServer extends JavaPlugin {

    MCHttpServer mchttpserver = new MCHttpServer();

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            mchttpserver.start();
            System.out.println("Http Server");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to start Http server");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        mchttpserver.stop();
        System.out.println("Shutdown");
    }
}
