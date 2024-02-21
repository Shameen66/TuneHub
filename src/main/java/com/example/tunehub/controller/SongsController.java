package com.example.tunehub.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.tunehub.entity.Songs;
import com.example.tunehub.entity.User;
import com.example.tunehub.services.SongService;
import com.example.tunehub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SongsController {
	@Autowired
	SongService Sservice;
	@Autowired
	UserService Uservice;
	@PostMapping("/addsongs")
	public String uploadSong(@RequestParam("songName") String songName,
			@RequestParam("songArtist") String songArtist,
			@RequestParam("songGenre") String songGenre,
			@RequestParam("songLink") String songLink,
			@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		if (!imageFile.isEmpty()) {
			// Convert the image file to a byte array
			byte[] imageData = imageFile.getBytes();

			// Convert byte array to base64 encoded string
			String base64ImageData = Base64.getEncoder().encodeToString(imageData);
			   Songs song = new Songs();
			boolean songexits=Sservice.songExits(song.getSongName());
			if(songexits==true) {
				System.out.println("song already exists.");
				return "addsongs";
			}else {
				 song.setSongName(songName);
		            song.setSongArtist(songArtist);
		            song.setSongGenre(songGenre);
		            song.setSongLink(songLink);
		            song.setImagedata(base64ImageData);
				Sservice.addSongs(song);

			}
		}

			return "addsongs";
		}

	
		@GetMapping("/viewsongs")
		public String viewsongs(Model modal) {
			List<Songs> songs=Sservice.getSongs();
			modal.addAttribute("songs", songs);
			return "viewsongs";
		}
		

		@GetMapping("/showsongs")
		public String showsongs(Model modal,HttpSession session) {
			String email=(String) session.getAttribute("email");
			User user=Uservice.getuser(email);
			System.out.println(email);
			boolean primestatus=user.isIspremium();
			if(primestatus==true) {
				List<Songs> songs=Sservice.getSongs();
				modal.addAttribute("songs", songs);
				return "showsongs";
			}else {
				return "makepayment";
			}
		}

	}
