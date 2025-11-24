public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
    for (int i = 0; i < sentences.length; i++) {
        int[] spaces = new int[sentences[i].length()];
        String[] words = new String[spaces.length + 1];
        int t = 0;

        // finding all the spaces
        for (int s = 0; s < sentences[i].length(); s++) {
            if (sentences[i].charAt(s) == ' ') {
                spaces[t] = s;
                t++;
            }
        }

        // cutting all the words in the sentence according to spaces
        int begging = 0;
        int wordsCounter = 0;
        for (int s = 0; s < t; s++) {
            words[wordsCounter] = sentences[i].substring(begging, spaces[s]);
            wordsCounter++;
            begging = spaces[s] + 1;
        }
        words[wordsCounter] = sentences[i].substring(begging);
        wordsCounter++;

        // checking for specific words
        for (int l = 0; l < wordsCounter; l++) {

            String cleanWord = words[l].replaceAll("[^A-Za-z]", "");

            for (int j = 0; j < keywords.length; j++) {

                if (cleanWord.equalsIgnoreCase(keywords[j])) {
                    System.out.println(sentences[i]);
                    break;
                }
            }
        }
    }
}
}