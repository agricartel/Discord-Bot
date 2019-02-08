package com.github.agricartel.discordbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.Activity;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.util.logging.ExceptionLogger;

public class Main
{
	public static DiscordApi api;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		login();
		
        System.out.println("Logged in");
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
        
        
        
        
        api.addMessageCreateListener(event -> {
        	
            if (event.getMessage().getContent().equalsIgnoreCase("!ping"))
            	
                event.getChannel().sendMessage("Pong!");

        });
        api.addMessageCreateListener(event -> {
        	
            if (event.getMessage().getContent().toLowerCase().contains("i hate ")) {
            	
                System.out.println(event.getMessage().getAuthor());
                event.getMessage().getServer().ifPresent(server ->
                event.getMessage().getUserAuthor().ifPresent(user ->
                server.updateNickname(user, "test")));
                
            }
            
        });


        api.addUserChangeActivityListener(event -> {
        	
        	if (event.getUser().isBotOwner()) {
        		
        		if(event.getOldActivity().map(Activity::getType).orElse(null) != event.getNewActivity().map(Activity::getType).orElse(null)) {
        			
        			//System.out.println("Ye");
        			if (event.getNewActivity().map(Activity::getType).orElse(null) == ActivityType.STREAMING) {
        				
        				//System.out.println("Yeye");
        				api
        					.getServerById("297818419930071040")
        					.flatMap(server -> server.getTextChannelById("297818419930071040"))
        					.ifPresent(channel -> channel
        							.sendMessage("Agric Artel is streaming on Twitch! https://www.twitch.tv/agricartel")
        					.exceptionally(ExceptionLogger.get()));
        				
        			}
        			
        		}
        		
        	}
        	
        });
        
        
        
        
	}
	
	public static DiscordApi login()
	{
	 	api = new DiscordApiBuilder()
				.setToken("NDE3NzQyMjU2NTYxMzI0MDQy.DktBdw.TRjYLeE6-0DKqa9x0tGcSPZQl9Q")
				.login()
				.join();
		
		api.updateActivity(ActivityType.WATCHING, "a titration");
		return api;
	}

}
