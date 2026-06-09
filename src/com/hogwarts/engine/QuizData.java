package com.hogwarts.engine;

import com.hogwarts.data.Question;

public class QuizData {
    public static Question[] getQuestions_text() {
        Question[] questions = new Question[11];

        questions[0] = new Question(
                "A peer is falsely accused of cheating. What do you do?",
                new String[]{
                        "Stand up immediately to defend them",
                        "Support them quietly and help clear their name",
                        "Gather evidence logically to prove innocence",
                        "Assess who benefits from the accusation"
                },
                new String[]{"G", "H", "R", "S"}
        );

        questions[1] = new Question(
                "Which path do you choose in an unknown forest?",
                new String[]{
                        "The well-trodden, safe path",
                        "The winding path with landmarks",
                        "The dark shortcut that's twice as fast",
                        "The steep, challenging rocky trail"
                },
                new String[]{"H", "R", "S", "G"}
        );

        questions[2] = new Question(
                "What tool or instrument are you drawn to?",
                new String[]{
                        "An ancient astrolabe for charting stars",
                        "A heavy ornate dagger from warriors",
                        "A master-key that unlocks any door",
                        "A sturdy artisan toolset for building"
                },
                new String[]{"R", "G", "S", "H"}
        );

        questions[3] = new Question(
                "In a team project, what role do you fall into?",
                new String[]{
                        "The strategist ensuring intellectual accuracy",
                        "The visionary planner driving high achievement",
                        "The vanguard handling the toughest parts",
                        "The dependable anchor smoothing conflicts"
                },
                new String[]{"R", "S", "G", "H"}
        );

        questions[4] = new Question(
                "What is your deepest fear?",
                new String[]{
                        "Being seen as incompetent or ordinary",
                        "Being powerless or failing your goals",
                        "Being remembered as a coward",
                        "Being isolated or letting people down"
                },
                new String[]{"R", "S", "G", "H"}
        );

        questions[5] = new Question(
                "You find a forbidden dark magic scroll in the library. What do you do?",
                new String[]{
                        "Hand it to the librarian — rules keep order",
                        "Keep it for yourself — rare knowledge is power",
                        "Track down the student to return it quietly",
                        "Confront the student directly about it"
                },
                new String[]{"R", "S", "H", "G"}
        );

        questions[6] = new Question(
                "Your friends dare you to sneak to the Forbidden Forest at midnight. What do you do?",
                new String[]{
                        "Go instantly — you refuse to look like a coward",
                        "Decline but promise not to tell anyone",
                        "Decline logically — the academic risk is too high",
                        "Go but make sure you won't be the one caught"
                },
                new String[]{"G", "H", "R", "S"}
        );

        questions[7] = new Question(
                "What object would you choose to hide a piece of your soul?",
                new String[]{
                        "A mundane tin can — no one would ever suspect it",
                        "A legendary Hogwarts heirloom worthy of your legacy",
                        "A rare spellbook holding priceless magical secrets",
                        "A weapon of renown like a goblin-wrought sword"
                },
                new String[]{"H", "S", "R", "G"}
        );

        questions[8] = new Question(
                "Which Deathly Hallow do you covet most?",
                new String[]{
                        "The Resurrection Stone — to honor lost loved ones",
                        "The Invisibility Cloak — to move unseen and explore",
                        "The Elder Wand — to never lose a confrontation",
                        "None — you would bravely defend them from evil"
                },
                new String[]{"H", "R", "S", "G"}
        );

        questions[9] = new Question(
                "Snape suddenly singles you out in Potions class. What's your internal reaction?",
                new String[]{
                        "Panic about looking foolish — your intellect is your pride",
                        "Worry about your track record and career ambitions",
                        "Speak up bravely despite his intimidating glare",
                        "Hope your friends quietly whisper a hint to help"
                },
                new String[]{"R", "S", "G", "H"}
        );

        questions[10] = new Question(
                "You discover your best friend has been lying to you for months to protect a secret. How do you react?",
                new String[]{
                        "Confront them immediately and demand the full truth, no matter how uncomfortable",
                        "Feel hurt but listen to their reason first — loyalty means giving them a chance to explain",
                        "Analyze the situation — figure out what they were hiding and why before reacting",
                        "Store the information carefully — knowing their secret gives you leverage for the future"
                },
                new String[]{"G", "H", "R", "S"}
        );

        return questions;
    }
}
