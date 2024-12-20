package fr.kirosnn.dCore.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Exemple de GUI personnalisée.
 */
public class ExampleGUI extends BaseGUI {

    private final Player player;

    public ExampleGUI(Player player) {
        super("Menu Exemple", 3);
        this.player = player;
    }

    @Override
    public void initialize() {
        ItemStack diamond = createItem(Material.DIAMOND, "Mon précieux !");
        setItems(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), diamond, null, null, null, null);
    }

    private ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
        return item;
    }
}