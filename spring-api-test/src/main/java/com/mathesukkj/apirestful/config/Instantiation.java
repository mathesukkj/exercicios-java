package com.mathesukkj.apirestful.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mathesukkj.apirestful.domain.Post;
import com.mathesukkj.apirestful.domain.User;
import com.mathesukkj.apirestful.dto.AuthorDTO;
import com.mathesukkj.apirestful.dto.CommentDTO;
import com.mathesukkj.apirestful.repositories.PostRepository;
import com.mathesukkj.apirestful.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
        @Autowired
        UserRepository userRepository;

        @Autowired
        PostRepository postRepository;

        @Override
        public void run(String... args) throws Exception {
                userRepository.deleteAll();
                postRepository.deleteAll();

                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                // gpt salva mt p seeding pprt xD
                User u1 = new User(null, "Fade", "nightm3r3scar@boo.com");
                User u2 = new User(null, "Gekko", "ashgekkum@wingmosh.com");
                User u3 = new User(null, "Jett", "brisinha@rogue.com");
                User u4 = new User(null, "Phoenix", "skkrrrrrrra@gz.com");
                User u5 = new User(null, "Sage", "notyourhealer@sentinels.com");
                User u6 = new User(null, "Sova", "mehunter@valo.com");
                User u7 = new User(null, "Neon", "zapzapzap@zap.com");
                User u8 = new User(null, "Yoru", "RAAAATINHO@xarola.com");

                userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8));

                Post p1 = new Post(null, LocalDate.parse("23/03/2023", df),
                                "hit an insane bugged spot in pearl lol, the enemy team didn't know what hit them! -7 rounds",
                                new AuthorDTO(u1));
                Post p2 = new Post(null, LocalDate.parse("22/03/2023", df),
                                "Just caught a new Pokémon! 🔥🔥🔥 It's time to level up and take on the next gym leader 💪 #GottaCatchEmAll #PokemonMaster #ValorantWho?",
                                new AuthorDTO(u2));
                Post p3 = new Post(null, LocalDate.parse("21/03/2023", df),
                                "Just pulled off the sickest clutch ever! My heart is racing but damn, it feels good to be a winner #JettMain #VALORANT",
                                new AuthorDTO(u3));
                Post p4 = new Post(null, LocalDate.parse("20/03/2023", df),
                                "Woohoo! Just scored my fourth ace in a row 🔥🔥🔥 I'm on fire baby! Don't mess with me when I've got my flames out 🔥🔥🔥",
                                new AuthorDTO(u4));
                Post p5 = new Post(null, LocalDate.parse("19/03/2023", df),
                                "Just saved my entire team with a clutch heal! There's nothing more satisfying than keeping everyone alive and in the fight 💪",
                                new AuthorDTO(u5));
                Post p6 = new Post(null, LocalDate.parse("18/03/2023", df),
                                "Just nailed a sick Recon Dart shot from across the map 👀🎯 Precision is key in this game",
                                new AuthorDTO(u6));
                Post p7 = new Post(null, LocalDate.parse("17/03/2023", df),
                                "Just zipped across the map with my electric charge ability and flanked the enemy team for an epic ace! ⚡️🏃‍♀️ They never saw it coming XDDDDDDDDDD noobs",
                                new AuthorDTO(u7));
                Post p8 = new Post(null, LocalDate.parse("16/03/2023", df),
                                "I'm a ninja in-game and out 😎 Just snuck up on an entire enemy team and took them all out before they even knew what hit them 🔪",
                                new AuthorDTO(u8));
                Post p9 = new Post(null, LocalDate.parse("16/03/2023", df),
                                "Just killed Tenz with xand's entry lmao he didnt even see my knives coming",
                                new AuthorDTO(u3));
                Post p10 = new Post(null, LocalDate.parse("16/03/2023", df),
                                "Feelin' hot as always. Nothing can stop me. 🔥",
                                new AuthorDTO(u4));

                CommentDTO c1 = new CommentDTO(
                                "Wow, that sounds crazy! You really caught the enemy team off guard. #PearlGang",
                                p1.getDate(), u3);
                CommentDTO c2 = new CommentDTO(
                                "Congrats on catching a new Pokémon! Which one was it? 🤔 #PokemonForever",
                                p2.getDate(), u2);
                CommentDTO c3 = new CommentDTO("Way to go on the clutch win! Jett mains unite! 🔥 #VALORANT",
                                p3.getDate(), u4);
                CommentDTO c4 = new CommentDTO(
                                "You're on fire alright! 🔥🔥🔥 Keep up the good work, ace machine! #AceKing",
                                p4.getDate(), u6);
                CommentDTO c6 = new CommentDTO(
                                "Nice shot with the Recon Dart! Precision is definitely key in this game. 👌 #ValorantTactics",
                                p6.getDate(), u4);
                CommentDTO c7 = new CommentDTO(
                                "Wow, you really zipped around the map and surprised the enemy team! ⚡️ #LightningFast",
                                p7.getDate(), u1);
                CommentDTO c8 = new CommentDTO("You're a ninja both in-game and out? Impressive! 😎 #StealthMaster",
                                p8.getDate(), u5);
                CommentDTO c9 = new CommentDTO(
                                "Taking out Tenz with xand's entry and knives? You're a force to be reckoned with! 🔪 #AssassinSkills",
                                p9.getDate(), u7);
                CommentDTO c10 = new CommentDTO(
                                "I've never heard of that bugged spot before. Thanks for sharing! 😂 #PearlGlitch",
                                p1.getDate(), u4);
                CommentDTO c11 = new CommentDTO(
                                "The adrenaline rush from a clutch win is unbeatable! Congrats on the victory. 🎉 #VALORANTChampion",
                                p3.getDate(), u8);

                p1.getComments().add(c1);
                p2.getComments().add(c2);
                p3.getComments().add(c3);
                p4.getComments().add(c4);
                p6.getComments().add(c6);
                p7.getComments().add(c7);
                p8.getComments().add(c8);
                p9.getComments().add(c9);
                p1.getComments().add(c10);
                p3.getComments().add(c11);

                postRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

                u1.getPosts().add(p1);
                u2.getPosts().add(p2);
                u3.getPosts().add(p3);
                u4.getPosts().add(p4);
                u5.getPosts().add(p5);
                u6.getPosts().add(p6);
                u7.getPosts().add(p7);
                u8.getPosts().add(p8);
                u3.getPosts().add(p9);
                u4.getPosts().add(p10);

                userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8));
        }
}
