package ***

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
//more imports

public class InventoryClickListener implements Listener {

    //static abuse
    public static IPets iPets = IPets.getPlugin(IPets.class);

    //...events..//

    @EventHandler
    public void onClick(InventoryClickEvent e){

        if(e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getView().getTitle().equals(ChatUtils.color("&6Select a Pet"))) {

                if (e.getCurrentItem() instanceof ItemStack) {
                    ItemStack item = e.getCurrentItem();

                    if(item.getType().equals(Material.BOOK)) {

                        if(PetManager.hasPet(p)){
                            p.sendMessage(ChatUtils.color("&cYou have already a pet enabled."));
                            p.sendMessage(ChatUtils.color("&7Disable it first /pets disable"));
                        } else {

                            String name = item.getItemMeta().getDisplayName();

                            EntityType type = EntityType.valueOf(name);

                            if (ConfigManager.isUnlocked(p, type)) {
                                PetManager.spawnPet(p, type);
                            } else {
                                p.sendMessage(ChatUtils.color("&cYou are not level " + ConfigManager.getLevelUnlock(type) + " yet!"));

                            }
                        }
                        p.closeInventory();
                        e.setCancelled(true);
                    }
                }
            }
        }

    }

}
