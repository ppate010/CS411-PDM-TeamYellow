package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimulationGUI extends JFrame {

    private GridBagConstraints gbc;
    private JLabel timeLabel;
    private JLabel garage1CapacityLabel;
    private JLabel garage2CapacityLabel;
    private JLabel garage3CapacityLabel;
    private JLabel garage4CapacityLabel;
    private JLabel garage5CapacityLabel;
    private JButton seeTrendsButton;

    private ArrayList<Garage> garages;

    // Initialize GUI for active portion of simulation
    public SimulationGUI(ArrayList<Garage> garagesList, int vehiclesPerMinute,
                         int avgTimeToPark, int avgParkTime, int simulationDuration, GridBagConstraints gbcReturn) {

        garages = garagesList; //initialize value for private var, enable access on all functions in this class

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set JFrame to full-screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gbc = gbcReturn;

        setLayout(new GridBagLayout());

        int time = 420;

        timeLabel = createLabel("Time: " + convertMinutesToAMPM(time), gbc);

        JPanel headingPanel = PDMPanels.createHeader("Garage Simulation");
        headingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(headingPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(timeLabel, gbc);

        switch (garages.size()) //create labels based on num of garages (up to 5)
        {
            case 1:
                gbc.gridy = 8;
                garage1CapacityLabel = createLabel(garages.get(0).getName() + " 0/" + Integer.toString(garages.get(0).getMaxCapacity()), gbc);
                add(garage1CapacityLabel, gbc);
                break;
            case 2:
                gbc.gridy = 8;
                garage1CapacityLabel = createLabel(garages.get(0).getName() + " 0/" + Integer.toString(garages.get(0).getMaxCapacity()), gbc);
                add(garage1CapacityLabel, gbc);

                gbc.gridy = 9;
                garage2CapacityLabel = createLabel(garages.get(1).getName() + " 0/" + Integer.toString(garages.get(1).getMaxCapacity()), gbc);
                add(garage2CapacityLabel, gbc);

                break;
            case 3:
                gbc.gridy = 8;
                garage1CapacityLabel = createLabel(garages.get(0).getName() + " 0/" + Integer.toString(garages.get(0).getMaxCapacity()), gbc);
                add(garage1CapacityLabel, gbc);

                gbc.gridy = 9;
                garage2CapacityLabel = createLabel(garages.get(1).getName() + " 0/" + Integer.toString(garages.get(1).getMaxCapacity()), gbc);
                add(garage2CapacityLabel, gbc);

                gbc.gridy = 10;
                garage3CapacityLabel = createLabel(garages.get(2).getName() + " 0/" + Integer.toString(garages.get(2).getMaxCapacity()), gbc);
                add(garage3CapacityLabel, gbc);

                break;
            case 4:
                gbc.gridy = 8;
                garage1CapacityLabel = createLabel(garages.get(0).getName() + " 0/" + Integer.toString(garages.get(0).getMaxCapacity()), gbc);
                add(garage1CapacityLabel, gbc);

                gbc.gridy = 9;
                garage2CapacityLabel = createLabel(garages.get(1).getName() + " 0/" + Integer.toString(garages.get(1).getMaxCapacity()), gbc);
                add(garage2CapacityLabel, gbc);

                gbc.gridy = 10;
                garage3CapacityLabel = createLabel(garages.get(2).getName() + " 0/" + Integer.toString(garages.get(2).getMaxCapacity()), gbc);
                add(garage3CapacityLabel, gbc);

                gbc.gridy = 11;
                garage4CapacityLabel = createLabel(garages.get(3).getName() + " 0/" + Integer.toString(garages.get(3).getMaxCapacity()), gbc);
                add(garage4CapacityLabel, gbc);

                break;
            case 5:
                gbc.gridy = 8;
                garage1CapacityLabel = createLabel(garages.get(0).getName() + " 0/" + Integer.toString(garages.get(0).getMaxCapacity()), gbc);
                add(garage1CapacityLabel, gbc);

                gbc.gridy = 9;
                garage2CapacityLabel = createLabel(garages.get(1).getName() + " 0/" + Integer.toString(garages.get(1).getMaxCapacity()), gbc);
                add(garage2CapacityLabel, gbc);

                gbc.gridy = 10;
                garage3CapacityLabel = createLabel(garages.get(2).getName() + " 0/" + Integer.toString(garages.get(2).getMaxCapacity()), gbc);
                add(garage3CapacityLabel, gbc);

                gbc.gridy = 11;
                garage4CapacityLabel = createLabel(garages.get(3).getName() + " 0/" + Integer.toString(garages.get(3).getMaxCapacity()), gbc);
                add(garage4CapacityLabel, gbc);

                gbc.gridy = 12;
                garage5CapacityLabel = createLabel(garages.get(4).getName() + " 0/" + Integer.toString(garages.get(4).getMaxCapacity()), gbc);
                add(garage5CapacityLabel, gbc);

                break;

        }

        gbc.gridy = 13;
        seeTrendsButton = createButton("See Trends", gbc);
        add(seeTrendsButton, gbc);
        seeTrendsButton.setVisible(true);

        // Repaint the frame to update the changes
        getContentPane().validate();
        getContentPane().repaint();

        seeTrendsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    trendsGUI trendsPage = new trendsGUI();
                    trendsPage.setVisible(true);
                });
            }
        });

        GarageSimulation garageSimulation = new GarageSimulation(this, garages, vehiclesPerMinute,
                avgTimeToPark, avgParkTime, simulationDuration, time);

    }

    // Called by simulation driver code at the end of each simulation tick
    public void updateSimLabels(ArrayList<Garage> garageList, int time) {

        garages = garageList; //update local private var with new info

        timeLabel.setText("Time: " + convertMinutesToAMPM(time));

        switch (garages.size()) //create labels based on num of garages (up to 5)
        {
            case 1:
                garage1CapacityLabel.setText(garages.get(0).getName() + " " + garages.get(0).getOccupancy() + "/" + garages.get(0).getMaxCapacity());
                break;
            case 2:
                garage1CapacityLabel.setText(garages.get(0).getName() + " " + garages.get(0).getOccupancy() + "/" + garages.get(0).getMaxCapacity());
                garage2CapacityLabel.setText(garages.get(1).getName() + " " + garages.get(1).getOccupancy() + "/" + garages.get(1).getMaxCapacity());
                break;
            case 3:
                garage1CapacityLabel.setText(garages.get(0).getName() + " " + garages.get(0).getOccupancy() + "/" + garages.get(0).getMaxCapacity());
                garage2CapacityLabel.setText(garages.get(1).getName() + " " + garages.get(1).getOccupancy() + "/" + garages.get(1).getMaxCapacity());
                garage3CapacityLabel.setText(garages.get(2).getName() + " " + garages.get(2).getOccupancy() + "/" + garages.get(2).getMaxCapacity());
                break;
            case 4:
                garage1CapacityLabel.setText(garages.get(0).getName() + " " + garages.get(0).getOccupancy() + "/" + garages.get(0).getMaxCapacity());
                garage2CapacityLabel.setText(garages.get(1).getName() + " " + garages.get(1).getOccupancy() + "/" + garages.get(1).getMaxCapacity());
                garage3CapacityLabel.setText(garages.get(2).getName() + " " + garages.get(2).getOccupancy() + "/" + garages.get(2).getMaxCapacity());
                garage4CapacityLabel.setText(garages.get(3).getName() + " " + garages.get(3).getOccupancy() + "/" + garages.get(3).getMaxCapacity());
                break;
            case 5:
                garage1CapacityLabel.setText(garages.get(0).getName() + " " + garages.get(0).getOccupancy() + "/" + garages.get(0).getMaxCapacity());
                garage2CapacityLabel.setText(garages.get(1).getName() + " " + garages.get(1).getOccupancy() + "/" + garages.get(1).getMaxCapacity());
                garage3CapacityLabel.setText(garages.get(2).getName() + " " + garages.get(2).getOccupancy() + "/" + garages.get(2).getMaxCapacity());
                garage4CapacityLabel.setText(garages.get(3).getName() + " " + garages.get(3).getOccupancy() + "/" + garages.get(3).getMaxCapacity());
                garage5CapacityLabel.setText(garages.get(4).getName() + " " + garages.get(4).getOccupancy() + "/" + garages.get(4).getMaxCapacity());
                break;
        }
    }

    private JLabel createLabel(String text, GridBagConstraints gbc) {
        JLabel label = new JLabel(text);

        // Increase font size
        Font labelFont = new Font("SansSerif", Font.BOLD, 18);
        label.setFont(labelFont);

        // Add padding and background color
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc.weightx = 0.0;
        gbc.gridx = 2;
        return label;
    }

    private JButton createButton(String text, GridBagConstraints gbc) {
        JButton button = new JButton(text);
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy++;
        return button;
    }

    public static String convertMinutesToAMPM(int minutes) {
        if (minutes < 0 || minutes >= 24 * 60) {
            throw new IllegalArgumentException("Invalid input: minutes must be between 0 and 1439.");
        }

        // Convert minutes to hours and minutes
        int hours = minutes / 60;
        int mins = minutes % 60;

        // Determine AM or PM
        String amPm;
        if (hours < 12) {
            amPm = "AM";
            if (hours == 0) {
                hours = 12;
            }
        } else {
            amPm = "PM";
            if (hours > 12) {
                hours -= 12;
            }
        }

        // Format the time as HH:MM AM/PM
        String formattedTime = String.format("%02d:%02d %s", hours, mins, amPm);

        return formattedTime;
    }
}

