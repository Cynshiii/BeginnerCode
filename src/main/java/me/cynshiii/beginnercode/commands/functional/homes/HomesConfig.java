package me.cynshiii.beginnercode.commands.functional.homes;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@SerializableAs("HomesConfig")
public class HomesConfig implements ConfigurationSerializable {
	private List<HomeOwner> homeOwners = new ArrayList<>();
	//lists homeowners and adds their homes to an array list for config

	public HomesConfig() {
		this(new HashMap<>());
	}

	public HomesConfig(Map<String, Object> map) {
		this.homeOwners = (List<HomeOwner>) map.getOrDefault("homeOwners", homeOwners);
		//reading to config
	}

	@Override
	public @NotNull Map<String, Object> serialize() {
		return new LinkedHashMap<>() {{
			put("homeOwners", homeOwners);
		}};
	}

	public HomeOwner getHomeOwner(Player player) {
		for (HomeOwner homeOwner : homeOwners) {
			if (homeOwner.getUuid().equals(player.getUniqueId().toString())) {
				return homeOwner;
				//looking for existing homeowner
			}
		}
		HomeOwner homeOwner = new HomeOwner(player.getUniqueId().toString());
		homeOwners.add(homeOwner);
		return homeOwner;
		//making and saving a new homeowner
	}

	@SerializableAs("HomeOwner")
	public static class HomeOwner implements ConfigurationSerializable{
		private String uuid;
		private List<Home> homes = new ArrayList<>();
		public HomeOwner() {
			this(new HashMap<>());
		}

		public HomeOwner(Map<String, Object> map) {
			//reading to config
			this.uuid = (String) map.get("uuid");
			this.homes = (List<Home>) map.getOrDefault("homes", homes);
			//assigning it the new array list from above
		}

		@Override
		public @NotNull Map<String, Object> serialize() {
			return new LinkedHashMap<>() {{
				put("uuid", uuid);
				put("homes", homes);
				//tells "bukkit shit" how to write to the config
			}};
		}

		public HomeOwner(String uuid) {
			this.uuid = uuid;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public List<Home> getHomes() {
			return homes;
		}

		public void setHomes(List<Home> homes) {
			this.homes = homes;
		}

		public Home getHome(String name) {
			for (Home home : homes) {
				if (home.getName().equals(name))
					return home;
			}
			return null;
		}
		//getters and setters for names and homes

		@SerializableAs("GoHome")
		public static class Home implements ConfigurationSerializable{
			private String name;
			private Location location;
			public Home() {
				this(new HashMap<>());
			}

			public Home(Map<String, Object> map) {
				//reading to config
				this.name = (String) map.get("name");
				this.location = (Location) map.get("location");
				//assigning it the new array list from above
			}

			@Override
			public @NotNull Map<String, Object> serialize() {
				return new LinkedHashMap<>() {{
					put("name", name);
					put("location", location);
					//tells "bukkit shit" how to write to the config
				}};
			}

			public Home(String name, Location location) {
				this.name = name;
				this.location = location;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Location getLocation() {
				return location;
			}

			public void setLocation(Location location) {
				this.location = location;
			}
		}
	}
}
/*
homesConfig:
	Griffin:
		:== GoHome
		name: base
		location:
			world: survival
			x: 0
			y: 0
			z: 0
		:== GoHome
		name: farm
		location:
			world: survival
			x: 10
			y: 10
			z: 10
	Cyn:
		:== GoHome
		name: base
		location:
			world: survival
			x: 100
			y: 0
			z: 100
		:== GoHome
		name: farm
		location:
			world: survival
			x: 50
			y: 0
			z: 50
 */
