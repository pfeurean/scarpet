__on_player_right_clicks_block(player, item_tuple, hand, block, face, hitvec)->(
    if (hand != 'mainhand', return());
    sugar = block('sugar_cane');
    air = block('air');

    item_mainhand = player ~ 'holds';
    if (!item_mainhand || !(item_mainhand:0 == 'bone_meal'), return());
    if(block != sugar, return());
    l(x,y,z) = pos(block);

    upstairs = block(x, y + 1, z);
    downstairs = block(x, y - 1, z);
    upupstairs = block(x, y + 2, z);
    downdownstairs = block(x, y - 2, z);

    if(upupstairs == sugar, return());
    if(upstairs == sugar && downstairs == sugar, return());
    if(downdownstairs == sugar, return());
    if(upstairs == sugar, target = pos(upstairs), target = pos(block));

    particle('happy_villager', target, 3, 0.4);
    block_tick(target);
    if (player ~ 'gamemode' == 'creative', return());
    inventory_remove(player(), 'bone_meal');
)
