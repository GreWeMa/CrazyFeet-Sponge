package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.item.inventory.property.SlotPos;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;

public class GuiPage2Cmd implements CommandExecutor {

	Inventory invs = Inventory.builder().of(InventoryArchetypes.CHEST)
			.property(InventoryDimension.PROPERTY_NAME, new InventoryDimension(9, 4))
			.property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(LanguageUtils.getText("crazyMenuTitlePage2")))
			.build(CrazyFeet.getPlugin());

	@Listener
	public void onInventoryClick(ClickInventoryEvent event, @First Player player) {
		if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			Transaction<ItemStackSnapshot> clickTransaction = event.getTransactions().get(0);
			ItemStack item = clickTransaction.getOriginal().createStack();
			if (item.getType().equals(ItemTypes.ENCHANTED_BOOK)) {

				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);

				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyhelixmenu"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.BOOK)) {

				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);

				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazymenu"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.SLIME_BALL)) {

				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazyglobe"))
						.submit(CrazyFeet.getInstance());
			}
			if (item.getType().equals(ItemTypes.WATER_BUCKET)) {

				player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
				Sponge.getScheduler().createTaskBuilder().delayTicks(1)
						.execute(() -> Sponge.getCommandManager().process(player, "crazystorm"))
						.submit(CrazyFeet.getInstance());
			}
			event.setCancelled(true);
		}
	}

	@Listener
	public void DropEvent(ClickInventoryEvent.Drop event) {
		if (event.getTargetInventory().getName().get().equals(this.invs.getName().get())) {
			event.setCancelled(true);
		}
	}

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext ctx) throws CommandException {
		Player player = (Player) src;
		ItemStack border = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
		border.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("crazyChooseParticleMode"));
		border.offer(Keys.DYE_COLOR, DyeColors.ORANGE);
		ItemStack cdisable = ItemStack.of(ItemTypes.BARRIER, 1);
		cdisable.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("crazyRemoveAllParticles"));
		ItemStack mhelix = ItemStack.of(ItemTypes.ENCHANTED_BOOK, 1);
		mhelix.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("crazyHelixColorPicker"));
		ItemStack mainmenu = ItemStack.of(ItemTypes.BOOK, 1);
		mainmenu.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("crazyBackToMainMenu"));
		ItemStack globe = ItemStack.of(ItemTypes.SLIME_BALL, 1);
		globe.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("crazyGlobe"));
		ItemStack storm = ItemStack.of(ItemTypes.WATER_BUCKET, 1);
		storm.offer(Keys.DISPLAY_NAME, LanguageUtils.getText("crazyStorm"));
		player.openInventory(invs);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 0))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 3))).set(cdisable);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 3))).set(mainmenu);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 3))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 2))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 1))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 1))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 1))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 2))).set(border);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 1))).set(mhelix);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 1))).set(globe);
		invs.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 1))).set(storm);
		player.sendMessage(LanguageUtils.getText("crazyPleaseSelectCrazyParticle"));
		player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
		return CommandResult.success();
	}
}
