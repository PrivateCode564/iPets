package ***

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
//more imports


public class Pet {

    private String petName;
    private EntityType petType;
    private Player petOwner;
    private Location petLocation;

    public Pet(String petName, EntityType petType, Player petOwner, Location petLocation){
        this.petName = petName;
        this.petType = petType;
        this.petOwner = petOwner;
        this.petLocation = petLocation;
    }

    public EntityType getPetType(Player petOwner){
        return PetManager.PETS.get(petOwner.getUniqueId()).petType;
    }

    public String getName(Player petOwner){
        return PetManager.PETS.get(petOwner.getUniqueId()).petName;
    }

    public void setPetLocation(Player petOwner, Location location){
        PetManager.PETS.get(petOwner.getUniqueId()).petLocation = location;

    }

    public Location getLocation(Player petOwner){
        return PetManager.PETS.get(petOwner.getUniqueId()).petLocation;
    }


}
