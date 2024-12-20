package fr.kirosnn.dCore.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

/**
 * Gestionnaire global pour les événements de GUI.
 */
public class GUIManager implements Listener {

    /**
     * Capture les clics dans les inventaires.
     *
     * @param event L'événement de clic.
     */
    @EventHandler
    public void onInventoryClick(@NotNull InventoryClickEvent event) {
        if (event.getView().getTopInventory().getHolder() instanceof BaseGUI baseGUI) {
            event.setCancelled(true);

            if (event.getClickedInventory() != null && event.getClickedInventory().equals(event.getView().getTopInventory())) {
                baseGUI.handleClick(event);
            }
        }
    }

    /**
     * Capture les drag and drop dans les inventaires.
     *
     * @param event L'événement de drag and drop.
     */
    @EventHandler
    public void onInventoryDrag(@NotNull InventoryDragEvent event) {
        if (event.getView().getTopInventory().getHolder() instanceof BaseGUI) {
            event.setCancelled(true);
        }
    }
}