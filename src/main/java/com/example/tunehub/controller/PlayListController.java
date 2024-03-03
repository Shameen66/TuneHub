package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entity.PlayList;
import com.example.tunehub.entity.Songs;
import com.example.tunehub.entity.User;
import com.example.tunehub.services.PlayListService;
import com.example.tunehub.services.SongService;
import com.example.tunehub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PlayListController {
	@Autowired
	PlayListService Pserv;
	@Autowired
	SongService Sserv;
	@Autowired
	UserService Uservice;
	
	@GetMapping("/createplaylist")
	public String CreatePlayList(Model modal) {
		List<Songs> songs=Sserv.getSongs();
		modal.addAttribute("songs", songs);
		return "createplaylist";
	}
	
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playlist) {
		System.out.println(playlist);
		System.out.println(playlist.getPlayListName());
		Pserv.addplaylist(playlist);
		List<Songs> songslist=playlist.getSong();
		for(Songs s:songslist) {
			s.getPlaylist().add(playlist);
			Sserv.updateSongs(s);
		}
		return "/createplaylist";
	}
	
	@GetMapping("/viewplaylist")
	public String viewplaylist(@RequestParam String playlistId,Model model,HttpSession session) {
		String email=(String) session.getAttribute("email");
		User user=Uservice.getuser(email);
		String role=user.getRole();
		boolean primestatus=user.isIspremium();
		List<PlayList> playlist=Pserv.fetchplaylists(Integer.parseInt(playlistId));
		if(role.equalsIgnoreCase("user")){
			if(primestatus==true) {
				model.addAttribute("playlist",playlist);
				return "showplaylistsongs";
			}else {
				return "/makepayment";
			}
		}else{
				model.addAttribute("playlist",playlist);
				return "showplaylistsongs";
		}
		
	}
	
	@GetMapping("/showplaylist")
	public String showplaylist(Model model) {
			List<PlayList> playlist=Pserv.fetchplaylists();
			model.addAttribute("playlist",playlist);
			return "showplaylist";
		
	}
}
