/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mamisaba.tuuti_plugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;



/**
 *
 * @author mami
 */



public class MamireimuServer_Post_Plugin extends JavaPlugin implements Listener {
    /**
     * 起動時処理
     */ 
    @Override
    public void onEnable() {
        getLogger().info("test enable");
        
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
    }

    /**
     * 終了時処理
     */
    @Override
    public void onDisable() {
        getLogger().info("test disable");
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) 
/*    {
        Player player = event.getPlayer();
        String name = player.getName();
        if(getConfig().getBoolean("Servernametf"))
        {
        	String msg2 = getConfig().getString("Servername");
        	player.sendMessage("ようこそ " + name + "さん "+ msg2 +"へようこそ");
        }

        if(player.hasPermission("tuuti.kengaku")) //tuuti.kengakuのパーミッションを持ってる場合
        {
        	String flm   = getConfig().getString("firstloginmessage").replaceAll("%player",name);
        	player.sendMessage(ChatColor.translateAlternateColorCodes('&',flm));
        }
        else if(!player.hasPlayedBefore()) //tuuti.kengakuを持ってなく、初参加者でない場合
        {
            if(getConfig().getBoolean("loginmessage"))
            {
            	String msg3 = getConfig().getString("message").replaceAll("%player",name);
            	player.sendMessage(ChatColor.translateAlternateColorCodes('&',msg3));
            }
        }
        else //tuuti.kengakuを持ってなく、初参加者である場合
        {
	        // ログインしたプレイヤーにようこそメッセージを表示する
	        if(getConfig().getBoolean("loginmessage"))
	        {
	        	String msg3 = getConfig().getString("message").replaceAll("%player",name);
	        	player.sendMessage(ChatColor.translateAlternateColorCodes('&',msg3));
	        }
        }
    }
            */
    {
        Player player = event.getPlayer();
        boolean sntf  = getConfig().getBoolean("Servernametf");//サーバー名表示するかどうかをconfigから取得
        String msg2 = getConfig().getString("Servername");//サーバー名取得
        boolean yn   = getConfig().getBoolean("loginmessage");//詳細を表示するかをconfigから取得
        String msg3 = getConfig().getString("message"); //詳細を取得
        String firstloginmessage   = getConfig().getString("firstloginmessage");//初回ログイン用メッセージ
        String sn ="ようこそ %playerさん "+ msg2 +"へようこそ\n";//サーバー名とプレイヤー名を合体
            
        if(sntf)//サーバー名を非表示するかのif文
        {
        }else{
        sn="";//サーバー名を非表示する
        }
        
        if(!player.hasPermission("tuuti.life")){    //初回ログインor未申請者の確認
            //未申請者の表示
        String fmsg =sn+ firstloginmessage;
        fmsg=fmsg.replaceAll("%player",event.getPlayer().getName());
        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',fmsg));
            //初ログイン+ログイン前に昇格した人
            
        }else{
        // ログインしたプレイヤーにようこそメッセージを表示する
        String lmsg =sn+ msg3 ;
        if(yn){
        lmsg=lmsg.replaceAll("%player",event.getPlayer().getName());
        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',lmsg));
        }
        }
    }
}
