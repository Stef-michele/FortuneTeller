import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneTextArea;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(400, 300)); // Adjusted panel size
        topPanel.setBackground(Color.WHITE);


        ImageIcon originalIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/fortuneball.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Adjusted size
        ImageIcon icon = new ImageIcon(scaledImage);

        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 48));
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.revalidate();
        topPanel.repaint();


        // Middle Panel
        fortuneTextArea = new JTextArea(10, 30);
        fortuneTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.setFont(new Font("Arial", Font.BOLD, 20));
        quitButton.setFont(new Font("Arial", Font.BOLD, 20));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        // Adding components to the frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortune List
        fortunes = new ArrayList<>();
        fortunes.add("You will unexpectedly become the proud owner of 17 mismatched socks.");
        fortunes.add("A thrilling time awaits you... in the line at the DMV.");
        fortunes.add("Be prepared for a pleasant surprise involving an unexpected pizza delivery.");
        fortunes.add("Now is the time to try something new, like talking to your houseplants.");
        fortunes.add("Someone you haven’t seen in a while will wave from a passing car. You'll miss it.");
        fortunes.add("You will soon embark on an adventure to find your missing left shoe.");
        fortunes.add("A new opportunity will present itself disguised as an awkward email.");
        fortunes.add("Good news will come to you by carrier pigeon. Watch the skies.");
        fortunes.add("You will conquer obstacles like tangled headphones and stubborn jar lids.");
        fortunes.add("A refreshing change is on its way—probably weather-related.");
        fortunes.add("You are destined for greatness. Just after one more nap.");
        fortunes.add("Your hard work will soon pay off, but probably in Monopoly money.");
        fortunes.add("Who believes in fortunes anyway");

        // Button Actions
        readFortuneButton.addActionListener((ActionEvent e) -> displayNewFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));

        // Frame Settings
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);
    }

    private void displayNewFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);

        lastFortuneIndex = index;
        fortuneTextArea.append(fortunes.get(index) + "\n");
    }
}