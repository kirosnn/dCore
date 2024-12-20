package fr.kirosnn.dCore;

import fr.kirosnn.dCore.gui.AdvancedGUI;
import fr.kirosnn.dCore.gui.ExampleGUI;
import fr.kirosnn.dCore.gui.GUIManager;
import fr.kirosnn.dCore.utils.LoggerUtils;
import fr.kirosnn.dCore.utils.YamlFile;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class dCore extends JavaPlugin {

    private LoggerUtils logger;

    @Override
    public void onEnable() {
        logger = new LoggerUtils(this);
        logger.info("dCore activé avec succès !");

        /** Exemple de log avec erreur */
        logger.error("Erreur de démarrage simulée !");

        /** Exemple de log avec warn */
        logger.warn("Erreur en warning de démarrage simulée !");

        /** Exemple d'utilisation d'un fichier YAML */
        YamlFile config = new YamlFile(this, "config.yml");

        /** Les GUI sont des Listeners, donc bien y importer */
        Bukkit.getPluginManager().registerEvents(new GUIManager(), this);
    }

    @Override
    public void onDisable() {
    }

    /** Exemple de commande ouvrant le AdvancedGUI */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player && command.getName().equalsIgnoreCase("advancedgui")) {
            AdvancedGUI gui = new AdvancedGUI(player);
            gui.open(player);
            return true;
        }
        if (sender instanceof Player player && command.getName().equalsIgnoreCase("classicgui")) {
            ExampleGUI gui = new ExampleGUI(player);
            gui.open(player);
            return true;
        }
        return false;
    }
}
