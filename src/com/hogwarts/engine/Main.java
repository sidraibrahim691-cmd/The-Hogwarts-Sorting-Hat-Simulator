package com.hogwarts.engine;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Run the GUI construction on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(() -> {
            try {
                // Instantiate your new separate Swing interface class
                SortingHatGUI frame = new SortingHatGUI();

                // Make the window visible to the user
                frame.setVisible(true);

            }
            catch (Exception e) {
                System.err.println("Failed to launch the Hogwarts Sorting Hat Experience: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}