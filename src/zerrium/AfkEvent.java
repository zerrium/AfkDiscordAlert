package zerrium;

import com.earth2me.essentials.IUser;
import github.scarsz.discordsrv.DiscordSRV;
import net.ess3.api.events.AfkStatusChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 *
 * @author willysusilo
 */
public class AfkEvent implements Listener {
    
    @EventHandler
    public void onPlayerAfkToggle(AfkStatusChangeEvent event){
        IUser p = event.getAffected();
        
        if(event.getValue()){ //goes AFK
            //send message
            String afk_reason = p.getAfkMessage() == null ? "" : p.getAfkMessage();
            DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName("global")
                    .sendMessage(":stare: " + p.getName() + " is now AFK" + (afk_reason.isEmpty() ? "." : (": " + afk_reason)))
                    .queue();
        }else{ //back from AFK
            DiscordSRV.getPlugin().getDestinationTextChannelForGameChannelName("global")
                    .sendMessage(":pika: " + p.getName() + " is no longer AFK.")
                    .queue();
        }
    }
}
