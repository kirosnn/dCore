package fr.kirosnn.dCore.gui;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Exemple avancé d'une GUI utilisant toutes les fonctionnalités.
 */
public class AdvancedGUI extends BaseGUI {

    private final Player player;

    public AdvancedGUI(Player player) {
        super("Menu avancé", 3);
        this.player = player;
    }

    @Override
    public void initialize() {
        Map<Enchantment, Integer> enchants = Map.of(Enchantment.EFFICIENCY, 1);
        List<ItemFlag> flags = List.of(ItemFlag.HIDE_ENCHANTS);
        List<String> loreItem1 = List.of("§7Appuyer ici pour fermer le menu");
        List<String> loreItem6 = Arrays.asList("§7Salut", "§aFonctionnalité spéciale");

        // Item 1 : Fermer le menu
        ItemStack closeItem = createItem(Material.BARRIER, "§cFermer le menu");
        setItem(11, closeItem, closeAction(), null, null, loreItem1);

        // Item 2 : Exécuter une commande
        ItemStack commandItem = createItem(Material.DIAMOND_SWORD, "§6Exécuter /help");
        setItem(13, commandItem, commandAction("help"), null, null, null);

        // Item 3 : Ouvrir un site
        ItemStack websiteItem = createItem(Material.PAPER, "§bOuvrir le site");
        setItem(21, websiteItem, openWebsiteAction("https://example.com", "§aCliquez ici pour visiter : §b{url}"), null, null, null);

        // Item 4 : Ouvrir une autre GUI
        ItemStack anotherGUIItem = createItem(Material.CHEST, "§aOuvrir une autre GUI");
        setItem(23, anotherGUIItem, openGUIAction(new ExampleGUI(player), player), null, null, null);

        // Item 5 : Changer un item avec une action
        ItemStack toggleItem = createItem(Material.RED_WOOL, "§cDésactivé");
        ItemStack toggledItem = createItem(Material.GREEN_WOOL, "§aActivé");

        // Lore, enchantements et flags pour l'item initial
        List<String> initialLore = Arrays.asList("§7Cliquez pour activer");
        Map<Enchantment, Integer> initialEnchants = Map.of(Enchantment.EFFICIENCY, 1);
        List<ItemFlag> initialFlags = Arrays.asList(ItemFlag.HIDE_ENCHANTS);

        // Lore, enchantements et flags pour l'item alternatif
        List<String> alternateLore = Arrays.asList("§7Cliquez pour désactiver");
        Map<Enchantment, Integer> alternateEnchants = Map.of(Enchantment.SHARPNESS, 1);
        List<ItemFlag> alternateFlags = Arrays.asList(ItemFlag.HIDE_ATTRIBUTES);

        // Ajout de l'item avec basculement
        setItemWithToggleAction(
                15,
                toggleItem,
                toggledItem,
                event -> {
                    Player player = (Player) event.getWhoClicked();
                    player.sendMessage("§aVous avez basculé l'état de l'item !");
                },
                initialEnchants,
                alternateEnchants,
                initialFlags,
                alternateFlags,
                initialLore,
                alternateLore
        );

        // Item 6 : Item avec enchantment, lore et flags
        ItemStack itemInteresting = createItem(Material.NETHERITE_SWORD, "§8Un item surprenant");
        setItem(22, itemInteresting, null, enchants, flags, loreItem6);

        // Définir un item dans plusieurs slots
        ItemStack decorationItem = createItem(Material.GRAY_STAINED_GLASS_PANE, " ");
        setItems(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), decorationItem, null, null, null, null);
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