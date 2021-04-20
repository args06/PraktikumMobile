package com.example.pertemuan3;

import java.util.ArrayList;

public class MoviesData {
    private static String[] movieNames = {
            "Godzilla vs. Kong",
            "The Unholy",
            "Nobody",
            "Raya and the Last Dragon",
            "Tom and Jerry",
            "The Girl Who Believes in Miracles",
            "The Courier",
            "Chaos Walking",
            "The Croods: A New Age",
            "French Exit"
    };

    private static String[] movieDetails = {
            "The epic next chapter in the cinematic Monsterverse pits two of the greatest icons in motion picture history against one another - the fearsome Godzilla and the mighty Kong - with humanity caught in the balance.",
            "A hearing-impaired girl is visited by the Virgin Mary and can suddenly hear, speak, and heal the sick. As people flock to witness her miracles, terrifying events unfold. Are they the work of the Virgin Mary or something much more sinister?",
            "A bystander who intervenes to help a woman being harassed by a group of men becomes the target of a vengeful drug lord.",
            "In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last dragon.",
            "A chaotic battle ensues between Jerry Mouse, who has taken refuge in the Royal Gate Hotel, and Tom Cat, who is hired to drive him away before the day of a big wedding arrives.",
            "Unlike most people, young Sara Hopkins is willing to take God at His word. So when she hears a preacher say faith can move mountains, she starts praying. What begins with a mysteriously healed bird leads to people suddenly cured of their misery and misfortune all over town. But the overwhelming crush of notoriety and press attention soon takes its toll on Sara. Will her family be able to save their miracle girl before it's too late?",
            "Cold War spy Greville Wynne and his Russian source try to put an end to the Cuban Missile Crisis.",
            "A dystopian world where there are no women and all living creatures can hear each other's thoughts in a stream of images, words, and sounds called Noise.",
            "The prehistoric family the Croods are challenged by a rival family the Bettermans, who claim to be better and more evolved.",
            "An aging Manhattan socialite living on what's barely left of her inheritance moves to a small apartment in Paris with her son and cat."
    };

    private static String[] movieImages = {
            "https://upload.wikimedia.org/wikipedia/en/6/63/Godzilla_vs._Kong.png",
            "https://upload.wikimedia.org/wikipedia/en/b/b2/The_Unholy_2021_Film_Poster.png",
            "https://upload.wikimedia.org/wikipedia/en/c/c7/Nobody_2021_Film_Poster.jpeg",
            "https://upload.wikimedia.org/wikipedia/en/e/ea/Raya_and_the_Last_Dragon.png",
            "https://upload.wikimedia.org/wikipedia/en/1/14/Tom_%26_Jerry_%28Official_2021_Film_Poster%29.png",
            "https://upload.wikimedia.org/wikipedia/en/4/4b/Girl_who_believes_in_miracles.jpg",
            "https://upload.wikimedia.org/wikipedia/en/5/55/The_Courier_poster.jpeg",
            "https://upload.wikimedia.org/wikipedia/en/6/63/Chaos_Walking_%28film%29.png",
            "https://upload.wikimedia.org/wikipedia/en/9/91/The_Croods_-_A_New_Age.png",
            "https://upload.wikimedia.org/wikipedia/en/7/7c/French_Exit_poster.jpeg"
    };

    private static String[] movieDirector = {
            "Adam Wingard",
            "Evan Spiliotopoulos",
            "Ilya Naishuller",
            "Don Hall, Carlos López Estrada",
            "Tim Story",
            "Richard Correll",
            "Dominic Cooke",
            "Doug Liman",
            "Joel Crawford",
            "Azazel Jacobs"
    };

    private static String[] movieReleaseDate = {
            "31 March 2021",
            "2 April 2021",
            "26 March 2021",
            "5 March 2021",
            "26 February 2021",
            "2 April 2021",
            "19 March 2021",
            "5 March 2021",
            "25 November 2020",
            "10 October 2020"
    };

    private static String[] movieRunningTime = {
            "1h 53min",
            "1h 39min",
            "1h 32min",
            "1h 47min",
            "1h 41min",
            "1h 40min",
            "1h 52min",
            "1h 49min",
            "1h 35min",
            "1h 53min"
    };

    static ArrayList<Movies> getListData(){
        ArrayList<Movies> list = new ArrayList<>();

        for (int position = 0; position < movieNames.length; position++){
            Movies movies = new Movies(
                    movieNames[position],
                    movieDetails[position],
                    movieImages[position],
                    movieDirector[position],
                    movieReleaseDate[position],
                    movieRunningTime[position]
            );
            list.add(movies);
        }
        return list;
    }
}
