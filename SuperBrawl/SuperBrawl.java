// The "SuperBrawl" class. (Inefficiency at its finest) ChangeLog (2/16/2016): [Code has been reduced from 1600 lines to just over 1350]
import java.awt.*;      //Just as a warning, this code is one of the most inefficient pieces of crap you may have ever witnessed. This was made by an
import hsa.Console;     //amateur, so expect the gameplay to also be a load of crap as well. You may experience this "crap" by noticing that the "tazer"
import java.util.Random;    //move does not do jack-shit and doesn't even stun the opponent, or the fact that only the blue player's moves actually have
//animations while the red guy just stands on the spot and doesn't do shit. Also, the nuke at the end of the 20 turns (between the
public class SuperBrawl     //blue guy and the red guy's turns) does not even detonate, which results in absolutely no sudden death, which is idiotic
{ //because a game could end up going on forever if both of the players are spamming the "heal" button. The code is also the most
    static Console c;   //inefficient and unlogical code that could be seen in Java. This game uses almost 3000 lines of code, but that's due to the fact
    //that I had no idea  what methods were, so it could have been cut down to about 1300 lines or something but w/e, enjoy :)
    //Colours
    static Color white = new Color (255, 255, 255);
    static Color black = new Color (0, 0, 0);
    static Color red = new Color (255, 0, 0);
    static Color green = new Color (0, 255, 0);
    static Color blue = new Color (0, 0, 255);
    //static Color lightblue = new Color (0, 77, 255); original background color
    static Color lightblue = new Color (77, 153, 255); //this color is much nicer, you can actually see the blue guy's HUD
    static Color yellow = new Color (255, 255, 0);
    static Color orange = new Color (255, 153, 0);
    static Color purple = new Color (153, 77, 255);
    static Color cyan = new Color (77, 255, 255);
    static Color darkblue = new Color (204, 255, 0);

    //Fonts
    static Font big = new Font ("SansSerif", Font.BOLD, 40);
    static Font small = new Font ("SansSerif", Font.BOLD, 20);
    static Font extra = new Font ("SansSerif", Font.BOLD, 60);
    static Font regular = new Font ("SansSerif", Font.BOLD, 30);

    public static void main (String[] args)
    {
	c = new Console ();

	Random random = new Random ();

	c.setColor (red);
	c.fillRect (0, 0, 1000, 1000);
	c.setFont (big);
	for (int y = 0, yrev = 250 ; y < 250 ; y++, yrev--)
	{
	    c.setColor (black);
	    c.drawString ("Get Recchi'd", 200, 175);
	    c.drawString ("Industries", 225, 225);
	    c.fillRect (0, 0, 1000, y);
	    c.fillRect (0, 250, 1000, 1000);
	    c.setColor (red);
	    c.fillRect (0, 250, 1000, yrev);
	    gottaGoFast ();
	}

	//Intro
	/*c.setColor (red);
	c.fillRect (0, 0, 1000, 1000);
	c.setColor (black);
	c.fillRect (0, 0, 1000, 100);
	c.fillRect (0, 400, 1000, 100);
	c.setFont (big);
	c.drawString ("Get Recchi'd", 200, 175);
	c.drawString ("Industries", 225, 225);
	c.drawString ("Presents...", 225, 300);
	threeSecDelay ();
	c.fillRect (0, 50, 1000, 100);
	c.fillRect (0, 350, 1000, 100);
	loadDelay ();
	c.fillRect (0, 100, 1000, 100);
	c.fillRect (0, 300, 1000, 100);
	loadDelay ();
	c.fillRect (0, 150, 1000, 150);
	try
	{
	    Thread.sleep (1500);
	}
	catch (InterruptedException ie)
	{
	}
	c.setColor (red);
	c.fillRect (0, 150, 1000, 150);
	c.setColor (black);
	c.drawString ("An Adrian", 200, 175);
	c.drawString ("Recchi", 225, 225);
	c.drawString ("Production...", 175, 300);
	loadDelay ();
	c.setColor (red);
	c.fillRect (0, 100, 1000, 75);
	c.fillRect (0, 300, 1000, 75);
	c.setColor (black);
	c.drawString ("An Adrian", 200, 175);
	c.drawString ("Recchi", 225, 225);
	c.setColor (red);
	loadDelay ();
	c.fillRect (0, 50, 1000, 75);
	c.fillRect (0, 350, 1000, 75);
	c.setColor (black);
	c.drawString ("An Adrian", 200, 175);
	threeSecDelay ();*/

	while (true)
	{
	    c.setFont (extra);
	    c.setColor (darkblue);
	    c.fillRect (0, 0, 1000, 1000);
	    c.setColor (red);
	    c.drawString ("Super Brawl", 150, 150);
	    c.setFont (small);
	    c.drawString ("2015-2016 Get Recchi'd Industries", 300, 490);
	    //c.drawString ("2015 Get Recchi'd Industries", 350, 490);
	    c.setColor (purple);
	    c.setFont (regular);
	    c.drawString ("Brawl = 1", 150, 300);
	    c.drawString ("Quit = 2", 400, 300);

	    int titleselection = Integer.parseInt (Character.toString (c.getChar ()));

	    if (titleselection == 1)
	    {
		c.setColor (purple);
		c.fillRect (0, 0, 1000, 1000);
		c.setColor (red);
		c.setFont (extra);
		c.drawString ("Loading", 200, 150);

		int hints = random.nextInt ((3 - 1) + 1) + 1;

		if (hints == 1)
		{
		    String hintLine1 = "Remember to strategize wisely! Spamming a single";
		    String hintLine2 = "move may not always be the best tactic!";
		    loadingBar (hintLine1, hintLine2);
		}

		else if (hints == 2)
		{
		    String hintLine1 = "Gaining the initiative in battle can seriously give";
		    String hintLine2 = "you the edge, and the key to victory!";
		    loadingBar (hintLine1, hintLine2);
		}

		else if (hints == 3)
		{
		    String hintLine1 = "More powerful moves have a higher chance of";
		    String hintLine2 = "missing! Keep this in mind!";
		    loadingBar (hintLine1, hintLine2);
		}

		//Battle setup scene thing begins at this point
		int battlescene = 0; //IMPORTANT DO NOT MOVE THIS VARIABLE
		int nukeStarter = 0;
		c.clear ();

		graphics ();

		//Battle initiative
		int initiative = random.nextInt ((9 - 1) + 1) + 1;

		c.setTextBackgroundColor (lightblue);
		c.setTextColor (yellow);
		c.setFont (small);
		c.setColor (orange);
		c.drawString ("Guess the number between 1-9 to see who goes first!", 10, 40);

		for (int initial = 1 ;; initial++)
		{
		    int playerCheck = initial % 2;

		    if (playerCheck == 0)
		    {
			c.setColor (blue);
			c.drawString ("Player 2", 550, 40);
			int guess = Integer.parseInt (Character.toString (c.getChar ()));
			c.clear ();
			if (guess != initiative)
			{
			    c.clear (); //Prevents graphics glitching (Not exactly working?)
			    graphics ();
			    initializer ();
			}
			else
			{
			    battlescene += 2;
			    nukeStarter += battlescene; //Starts nuke count at end of player 1's turn
			    break;
			}
		    }
		    else if (playerCheck >= 1)
		    {
			c.setColor (red);
			c.drawString ("Player 1", 550, 40);
			int guess = Integer.parseInt (Character.toString (c.getChar ()));
			c.clear ();
			if (guess != initiative)
			{
			    c.clear (); //Prevents graphics glitching
			    graphics ();
			    initializer ();
			}
			else
			{
			    battlescene++;
			    nukeStarter += battlescene; //Starts nuke count at end of player 2's turn
			    break;
			}
		    }
		}
		//The battle scene intro
		graphics ();

		c.setColor (yellow);
		c.setFont (extra);
		c.drawString ("3", 300, 200);
		loadDelay ();

		graphics ();

		c.setColor (yellow);
		c.drawString ("2", 300, 200);
		loadDelay ();

		graphics ();

		c.setColor (yellow);
		c.drawString ("1", 300, 200);
		loadDelay ();

		graphics ();

		c.setColor (orange);
		c.drawString ("BRAWL!!", 200, 200);
		loadDelay ();

		//Battle stats and moves and all that other stuff is here
		int redHP = 10;
		int blueHP = 10;
		int redTazer = 0;
		int blueTazer = 0;
		int redAid = 0;
		int blueAid = 0;
		int tazerAccuracyIncrease = 0;
		int nukeCountdown = 20; //warning at 15 turns but goes off at 20 and draws the game
		//REMINDER===[nukeStarter is a variable if a player guessed initiative correctly]===REMINDER

		//The battle scene WHERE ALL THE ACTION HAPPENS DASDASFDFASASDFASFDFASDSDFFASASFSDFS NUKE IT
		for (;; battlescene++)
		{
		    int playerMove = battlescene % 2; //Checks to see who's turn it is

		    //Player 2's move
		    if (playerMove == 0)
		    {
			//PLAYER 2 IS DEAD 777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
			if (blueHP <= 0)
			{
			    c.clear ();
			    c.setColor (Color.CYAN);
			    c.fillRect (0, 0, 1000, 1000);

			    c.setColor (red); //if something goes wrong, this is to blame
			    victoryGuy ();

			    c.setColor (yellow);
			    c.drawString ("VICTORY!!", 100, 100);

			    fiveSecDelay ();
			    break;
			}

			graphics ();
			String topScreen = "Player 2";
			c.setColor (blue);
			HUD (redHP, blueHP, topScreen); //Displays life and movesets

			String moveChoice = Character.toString (c.getChar ());

			//Fireball move choice
			if (moveChoice.equals ("q"))
			{
			    int accuracy = random.nextInt (100) + tazerAccuracyIncrease;

			    //Move hits
			    if (accuracy >= 30)
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Fireball Initiated", 200, 200);
				twoSecDelay ();
				c.setColor (orange);
				c.fillOval (387, 325, 75, 75);
				animationDelay ();
				graphics ();
				c.setColor (orange);
				c.fillOval (312, 325, 75, 75);
				animationDelay ();
				graphics ();
				c.setColor (orange);
				c.fillOval (237, 325, 75, 75);
				animationDelay ();
				graphics ();
				c.setColor (orange);
				c.fillOval (162, 325, 75, 75);
				animationDelay ();
				graphics ();
				c.setColor (orange);
				c.fillOval (47, 275, 150, 150);
				c.setColor (black);
				c.drawString ("KABOOM!", 67, 355);
				animationDelay ();
				graphics ();

				redHP -= 30;
				tazerAccuracyIncrease = 0;
			    }

			    //Move misses
			    else
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Fireball Initiated", 200, 200);
				twoSecDelay ();
				graphics ();

				c.setColor (purple);
				c.drawString ("Fireball Blocked", 200, 200);
				twoSecDelay ();
				tazerAccuracyIncrease = 0;
			    }
			}

			//Icebolt move choice
			else if (moveChoice.equals ("w"))
			{
			    int accuracy = random.nextInt (100) + tazerAccuracyIncrease;

			    //Move hits
			    if (accuracy >= 10)
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Icebolt Initiated", 200, 200);
				twoSecDelay ();
				c.setColor (cyan);
				c.fillRect (140, 100, 10, 120);
				animationDelay ();
				graphics ();
				c.setColor (cyan);
				c.fillRect (50, 200, 100, 100);
				c.fillRect (75, 300, 50, 100);
				c.fillRect (125, 325, 50, 50);
				c.fillRect (25, 325, 50, 50);
				c.fillRect (125, 400, 50, 50);
				c.fillRect (25, 400, 50, 50);
				twoSecDelay ();
				graphics ();

				redHP -= 20;
				tazerAccuracyIncrease = 0;
			    }

			    //Move misses
			    else
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Icebolt Initiated", 200, 200);
				twoSecDelay ();
				graphics ();

				c.setColor (purple);
				c.drawString ("Icebolt Blocked", 200, 200);
				twoSecDelay ();
				tazerAccuracyIncrease = 0;
			    }
			}

			//Right Hook move choice
			else if (moveChoice.equals ("e"))
			{
			    int accuracy = random.nextInt (100) + tazerAccuracyIncrease;

			    //Move hits
			    if (accuracy >= 50)
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Right Hook Initiated", 200, 200);
				twoSecDelay ();
				graphicsHook ();
				c.setColor (blue);
				c.fillRect (437, 200, 100, 100);
				c.fillRect (462, 300, 50, 100);
				c.fillRect (512, 325, 50, 50);
				c.fillRect (412, 325, 50, 50);
				c.fillRect (512, 400, 50, 50);
				c.fillRect (412, 400, 50, 50);
				c.setColor (black);
				c.fillRect (457, 220, 20, 20);
				c.fillRect (497, 220, 20, 20);
				c.fillRect (457, 260, 60, 20);
				c.setColor (black);
				c.drawRect (437, 200, 100, 100);
				c.drawRect (462, 300, 50, 100);
				c.drawRect (512, 325, 50, 50);
				c.drawRect (412, 325, 50, 50);
				c.drawRect (512, 400, 50, 50);
				c.drawRect (412, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (387, 200, 100, 100);
				c.fillRect (412, 300, 50, 100);
				c.fillRect (462, 325, 50, 50);
				c.fillRect (362, 325, 50, 50);
				c.fillRect (462, 400, 50, 50);
				c.fillRect (362, 400, 50, 50);
				c.setColor (black);
				c.fillRect (407, 220, 20, 20);
				c.fillRect (447, 220, 20, 20);
				c.fillRect (407, 260, 60, 20);
				c.setColor (black);
				c.drawRect (387, 200, 100, 100);
				c.drawRect (412, 300, 50, 100);
				c.drawRect (462, 325, 50, 50);
				c.drawRect (362, 325, 50, 50);
				c.drawRect (462, 400, 50, 50);
				c.drawRect (362, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (337, 200, 100, 100);
				c.fillRect (362, 300, 50, 100);
				c.fillRect (412, 325, 50, 50);
				c.fillRect (312, 325, 50, 50);
				c.fillRect (412, 400, 50, 50);
				c.fillRect (312, 400, 50, 50);
				c.setColor (black);
				c.fillRect (357, 220, 20, 20);
				c.fillRect (397, 220, 20, 20);
				c.fillRect (357, 260, 60, 20);
				c.setColor (black);
				c.drawRect (337, 200, 100, 100);
				c.drawRect (362, 300, 50, 100);
				c.drawRect (412, 325, 50, 50);
				c.drawRect (312, 325, 50, 50);
				c.drawRect (412, 400, 50, 50);
				c.drawRect (312, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (287, 200, 100, 100);
				c.fillRect (312, 300, 50, 100);
				c.fillRect (362, 325, 50, 50);
				c.fillRect (262, 325, 50, 50);
				c.fillRect (362, 400, 50, 50);
				c.fillRect (262, 400, 50, 50);
				c.setColor (black);
				c.fillRect (307, 220, 20, 20);
				c.fillRect (347, 220, 20, 20);
				c.fillRect (307, 260, 60, 20);
				c.setColor (black);
				c.drawRect (287, 200, 100, 100);
				c.drawRect (312, 300, 50, 100);
				c.drawRect (362, 325, 50, 50);
				c.drawRect (262, 325, 50, 50);
				c.drawRect (362, 400, 50, 50);
				c.drawRect (262, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (237, 200, 100, 100);
				c.fillRect (262, 300, 50, 100);
				c.fillRect (312, 325, 50, 50);
				c.fillRect (212, 325, 50, 50);
				c.fillRect (312, 400, 50, 50);
				c.fillRect (212, 400, 50, 50);
				c.setColor (black);
				c.fillRect (257, 220, 20, 20);
				c.fillRect (297, 220, 20, 20);
				c.fillRect (257, 260, 60, 20);
				c.setColor (black);
				c.drawRect (237, 200, 100, 100);
				c.drawRect (262, 300, 50, 100);
				c.drawRect (312, 325, 50, 50);
				c.drawRect (212, 325, 50, 50);
				c.drawRect (312, 400, 50, 50);
				c.drawRect (212, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (212, 200, 100, 100);
				c.fillRect (237, 300, 50, 100);
				c.fillRect (287, 325, 50, 50);
				c.fillRect (187, 325, 50, 50);
				c.fillRect (287, 400, 50, 50);
				c.fillRect (187, 400, 50, 50);
				c.setColor (black);
				c.fillRect (232, 220, 20, 20);
				c.fillRect (272, 220, 20, 20);
				c.fillRect (232, 260, 60, 20);
				c.setColor (black);
				c.drawRect (212, 200, 100, 100);
				c.drawRect (237, 300, 50, 100);
				c.drawRect (287, 325, 50, 50);
				c.drawRect (187, 325, 50, 50);
				c.drawRect (287, 400, 50, 50);
				c.drawRect (187, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (212, 200, 100, 100);
				c.fillRect (237, 300, 50, 100);
				c.fillRect (287, 325, 50, 50);
				c.fillRect (137, 325, 50, 50);
				c.fillRect (287, 400, 50, 50);
				c.fillRect (187, 400, 50, 50);
				c.setColor (black);
				c.fillRect (232, 220, 20, 20);
				c.fillRect (272, 220, 20, 20);
				c.fillRect (232, 260, 60, 20);
				c.setColor (black);
				c.drawRect (212, 200, 100, 100);
				c.drawRect (237, 300, 50, 100);
				c.drawRect (287, 325, 50, 50);
				c.drawRect (137, 325, 50, 50);
				c.drawRect (287, 400, 50, 50);
				c.drawRect (187, 400, 50, 50);
				animationDelay ();

				//going in reverse
				graphicsHook ();
				c.setColor (blue);
				c.fillRect (212, 200, 100, 100);
				c.fillRect (237, 300, 50, 100);
				c.fillRect (287, 325, 50, 50);
				c.fillRect (187, 325, 50, 50);
				c.fillRect (287, 400, 50, 50);
				c.fillRect (187, 400, 50, 50);
				c.setColor (black);
				c.fillRect (232, 220, 20, 20);
				c.fillRect (272, 220, 20, 20);
				c.fillRect (232, 260, 60, 20);
				c.setColor (black);
				c.drawRect (212, 200, 100, 100);
				c.drawRect (237, 300, 50, 100);
				c.drawRect (287, 325, 50, 50);
				c.drawRect (187, 325, 50, 50);
				c.drawRect (287, 400, 50, 50);
				c.drawRect (187, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (237, 200, 100, 100);
				c.fillRect (262, 300, 50, 100);
				c.fillRect (312, 325, 50, 50);
				c.fillRect (212, 325, 50, 50);
				c.fillRect (312, 400, 50, 50);
				c.fillRect (212, 400, 50, 50);
				c.setColor (black);
				c.fillRect (257, 220, 20, 20);
				c.fillRect (297, 220, 20, 20);
				c.fillRect (257, 260, 60, 20);
				c.setColor (black);
				c.drawRect (237, 200, 100, 100);
				c.drawRect (262, 300, 50, 100);
				c.drawRect (312, 325, 50, 50);
				c.drawRect (212, 325, 50, 50);
				c.drawRect (312, 400, 50, 50);
				c.drawRect (212, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (287, 200, 100, 100);
				c.fillRect (312, 300, 50, 100);
				c.fillRect (362, 325, 50, 50);
				c.fillRect (262, 325, 50, 50);
				c.fillRect (362, 400, 50, 50);
				c.fillRect (262, 400, 50, 50);
				c.setColor (black);
				c.fillRect (307, 220, 20, 20);
				c.fillRect (347, 220, 20, 20);
				c.fillRect (307, 260, 60, 20);
				c.setColor (black);
				c.drawRect (287, 200, 100, 100);
				c.drawRect (312, 300, 50, 100);
				c.drawRect (362, 325, 50, 50);
				c.drawRect (262, 325, 50, 50);
				c.drawRect (362, 400, 50, 50);
				c.drawRect (262, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (337, 200, 100, 100);
				c.fillRect (362, 300, 50, 100);
				c.fillRect (412, 325, 50, 50);
				c.fillRect (312, 325, 50, 50);
				c.fillRect (412, 400, 50, 50);
				c.fillRect (312, 400, 50, 50);
				c.setColor (black);
				c.fillRect (357, 220, 20, 20);
				c.fillRect (397, 220, 20, 20);
				c.fillRect (357, 260, 60, 20);
				c.setColor (black);
				c.drawRect (337, 200, 100, 100);
				c.drawRect (362, 300, 50, 100);
				c.drawRect (412, 325, 50, 50);
				c.drawRect (312, 325, 50, 50);
				c.drawRect (412, 400, 50, 50);
				c.drawRect (312, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (387, 200, 100, 100);
				c.fillRect (412, 300, 50, 100);
				c.fillRect (462, 325, 50, 50);
				c.fillRect (362, 325, 50, 50);
				c.fillRect (462, 400, 50, 50);
				c.fillRect (362, 400, 50, 50);
				c.setColor (black);
				c.fillRect (407, 220, 20, 20);
				c.fillRect (447, 220, 20, 20);
				c.fillRect (407, 260, 60, 20);
				c.setColor (black);
				c.drawRect (387, 200, 100, 100);
				c.drawRect (412, 300, 50, 100);
				c.drawRect (462, 325, 50, 50);
				c.drawRect (362, 325, 50, 50);
				c.drawRect (462, 400, 50, 50);
				c.drawRect (362, 400, 50, 50);
				animationDelay ();

				graphicsHook ();
				c.setColor (blue);
				c.fillRect (437, 200, 100, 100);
				c.fillRect (462, 300, 50, 100);
				c.fillRect (512, 325, 50, 50);
				c.fillRect (412, 325, 50, 50);
				c.fillRect (512, 400, 50, 50);
				c.fillRect (412, 400, 50, 50);
				c.setColor (black);
				c.fillRect (457, 220, 20, 20);
				c.fillRect (497, 220, 20, 20);
				c.fillRect (457, 260, 60, 20);
				c.setColor (black);
				c.drawRect (437, 200, 100, 100);
				c.drawRect (462, 300, 50, 100);
				c.drawRect (512, 325, 50, 50);
				c.drawRect (412, 325, 50, 50);
				c.drawRect (512, 400, 50, 50);
				c.drawRect (412, 400, 50, 50);
				animationDelay ();

				redHP -= 70;
				tazerAccuracyIncrease = 0;
			    }

			    //Move misses
			    else
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Right Hook Initiated", 200, 200);
				twoSecDelay ();
				graphics ();

				c.setColor (purple);
				c.drawString ("Right Hook Blocked", 200, 200);
				twoSecDelay ();
				tazerAccuracyIncrease = 0;
			    }
			}

			//Tazer move choice
			else if (moveChoice.equals ("r"))
			{
			    //Runs if tazer is available
			    if (blueTazer == 0) //change the variable to redTazer for player 1
			    {
				blueTazer += 5;

				int accuracy = random.nextInt (100);

				//Move hits
				if (accuracy >= 30)
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("Tazer Initiated", 200, 200);
				    twoSecDelay ();
				    //add animations here

				    battlescene--;
				    tazerAccuracyIncrease = 50;
				}

				//Move misses
				else
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("Tazer Initiated", 200, 200);
				    twoSecDelay ();
				    graphics ();

				    c.setColor (purple);
				    c.drawString ("Tazer Blocked", 200, 200);
				    twoSecDelay ();
				}
			    }

			    //Runs if tazer is still cooling down
			    else
			    {
				c.setColor (purple);
				c.setFont (small);
				c.drawString ("Tazer on cooldown (" + blueTazer + ")", 200, 200); //change variable to redTazer for player 1
				twoSecDelay ();
				battlescene--;
				blueTazer++;
				nukeCountdown++;
			    }
			}

			//First-Aid move choice
			else if (moveChoice.equals ("t"))
			{
			    //Runs if First-Aid is available
			    if (blueAid == 0) //change variable to redAid for player 1
			    {
				blueAid += 2;

				int accuracy = random.nextInt (100);

				//Move hits
				if (accuracy >= 30)
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("First-Aid Initiated", 200, 200);
				    twoSecDelay ();
				    graphics ();
				    c.setColor (white);
				    c.fillRect (550, 20, 50, 50);
				    animationDelay ();

				    blueHP += 30;
				    tazerAccuracyIncrease = 0;
				}

				//Move misses
				else
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("First-Aid Initiated", 200, 200);
				    twoSecDelay ();
				    graphics ();

				    c.setColor (purple);
				    c.drawString ("First-Aid Ineffective", 200, 200);
				    blueHP += 10;
				    twoSecDelay ();
				    tazerAccuracyIncrease = 0;
				}
			    }

			    //Runs this if First-Aid is on cooldown
			    else
			    {
				c.setColor (purple);
				c.setFont (small);
				c.drawString ("First-Aid on cooldown (" + blueAid + ")", 200, 200); //change variable to redAid for player 1
				twoSecDelay ();
				battlescene--;
				blueAid++;
				nukeCountdown++;
			    }
			}

			//If the user decided to enter something that wasn't a choice
			else if (!moveChoice.equals ("q"))
			    battlescene--;

			//Cooldowns for tazer and First-Aid
			blueTazer--;
			blueAid--;

			//Error traps Tazer
			if (blueTazer < 0)
			    blueTazer++;

			//Error traps First-Aid
			if (blueAid < 0)
			    blueAid++;

			//Runs nuke process if player 1 had the initial move, runs at end of player 2's turn
			if (nukeStarter == 1)
			{
			    nukeCountdown--;

			    //Gives players a warning of death in a certain amount of turns
			    if (nukeCountdown >= 1 && nukeCountdown <= 5)
				nukeWarning (nukeCountdown);

			    //Kills both players and draws the game due to overexceeded time
			    if (nukeCountdown == 0)
				nukeOverLoad ();
			}
		    }

		    //Player 1's move
		    else
		    {
			//PLAYER 1 IS DEAD 777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
			if (redHP <= 0)
			{
			    c.clear ();
			    c.setColor (Color.CYAN);
			    c.fillRect (0, 0, 1000, 1000);

			    c.setColor (blue); //if something goes wrong, this is to blame
			    victoryGuy ();

			    c.setColor (yellow);
			    c.drawString ("VICTORY!!", 100, 100);

			    fiveSecDelay ();
			    break;
			}

			graphics ();
			String topScreen = "Player 1";
			c.setColor (red);
			HUD (redHP, blueHP, topScreen); //Displays life and movesets

			String moveChoice = Character.toString (c.getChar ());

			//Fireball move choice
			if (moveChoice.equals ("q"))
			{
			    int accuracy = random.nextInt (100) + tazerAccuracyIncrease;

			    //Move hits
			    if (accuracy >= 30)
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Fireball Initiated", 200, 200);
				twoSecDelay ();
				blueHP -= 30;
				tazerAccuracyIncrease = 0;
			    }

			    //Move misses
			    else
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Fireball Initiated", 200, 200);
				twoSecDelay ();
				graphics ();

				c.setColor (purple);
				c.drawString ("Fireball Blocked", 200, 200);
				twoSecDelay ();
				tazerAccuracyIncrease = 0;
			    }
			}

			//Icebolt move choice
			else if (moveChoice.equals ("w"))
			{
			    int accuracy = random.nextInt (100) + tazerAccuracyIncrease;

			    //Move hits
			    if (accuracy >= 10)
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Icebolt Initiated", 200, 200);
				twoSecDelay ();
				blueHP -= 20;
				tazerAccuracyIncrease = 0;
			    }

			    //Move misses
			    else
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Icebolt Initiated", 200, 200);
				twoSecDelay ();
				graphics ();

				c.setColor (purple);
				c.drawString ("Icebolt Blocked", 200, 200);
				twoSecDelay ();
				tazerAccuracyIncrease = 0;
			    }
			}

			//Right Hook move choice
			else if (moveChoice.equals ("e"))
			{
			    int accuracy = random.nextInt (100) + tazerAccuracyIncrease;

			    //Move hits
			    if (accuracy >= 50)
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Right Hook Initiated", 200, 200);
				twoSecDelay ();
				blueHP -= 70;
				tazerAccuracyIncrease = 0;
			    }

			    //Move misses
			    else
			    {
				c.setColor (orange);
				c.setFont (small);
				c.drawString ("Right Hook Initiated", 200, 200);
				twoSecDelay ();
				graphics ();

				c.setColor (purple);
				c.drawString ("Right Hook Blocked", 200, 200);
				twoSecDelay ();
				tazerAccuracyIncrease = 0;
			    }
			}

			//Tazer move choice
			else if (moveChoice.equals ("r"))
			{
			    //Runs if tazer is available
			    if (redTazer == 0)
			    {
				redTazer += 5;

				int accuracy = random.nextInt (100);

				//Move hits
				if (accuracy >= 30)
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("Tazer Initiated", 200, 200);
				    twoSecDelay ();
				    //add animations here

				    battlescene--;
				    tazerAccuracyIncrease = 50;
				}

				//Move misses
				else
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("Tazer Initiated", 200, 200);
				    twoSecDelay ();
				    graphics ();

				    c.setColor (purple);
				    c.drawString ("Tazer Blocked", 200, 200);
				    twoSecDelay ();
				}
			    }

			    //Runs if tazer is still cooling down
			    else
			    {
				c.setColor (purple);
				c.setFont (small);
				c.drawString ("Tazer on cooldown (" + redTazer + ")", 200, 200);
				twoSecDelay ();
				battlescene--;
				redTazer++;
				nukeCountdown++;
			    }
			}

			//First-Aid move choice
			else if (moveChoice.equals ("t"))
			{
			    //Runs if First-Aid is available
			    if (redAid == 0)
			    {
				redAid += 2;

				int accuracy = random.nextInt (100);

				//Move hits
				if (accuracy >= 30)
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("First-Aid Initiated", 200, 200);
				    twoSecDelay ();
				    redHP += 30;
				    tazerAccuracyIncrease = 0;
				}

				//Move misses
				else
				{
				    c.setColor (orange);
				    c.setFont (small);
				    c.drawString ("First-Aid Initiated", 200, 200);
				    twoSecDelay ();
				    graphics ();

				    c.setColor (purple);
				    c.drawString ("First-Aid Ineffective", 200, 200);
				    redHP += 10;
				    twoSecDelay ();
				    tazerAccuracyIncrease = 0;
				}
			    }

			    //Runs this if First-Aid is on cooldown
			    else
			    {
				c.setColor (purple);
				c.setFont (small);
				c.drawString ("First-Aid on cooldown (" + redAid + ")", 200, 200);
				twoSecDelay ();
				battlescene--;
				redAid++;
				nukeCountdown++;
			    }
			}

			//If the user decided to enter something that wasn't a choice
			else if (!moveChoice.equals ("q"))
			    battlescene--;

			//Cooldowns for tazer and First-Aid
			redTazer--;
			redAid--;

			//Error traps Tazer
			if (redTazer < 0)
			    redTazer++;

			//Error traps First-Aid
			if (redAid < 0)
			    redAid++;

			//Runs nuke process if player 2 had the initial move, runs at end of player 1's turn
			if (nukeStarter == 2)
			{
			    nukeCountdown--;

			    //Gives players a warning of death in a certain amount of turns
			    if (nukeCountdown >= 1 && nukeCountdown <= 5)
				nukeWarning (nukeCountdown);

			    //Kills both players and draws the game due to overexceeded time
			    if (nukeCountdown == 0)
				nukeOverLoad ();
			}
		    }
		}
	    }

	    else if (titleselection == 2)
	    {
		c.close ();
		break; //Prevents errors from occurring after game shuts down
	    }
	}
    }


    public static void gottaGoFast ()
    {
	try
	{
	    Thread.sleep (10);
	}
	catch (InterruptedException ie)
	{
	}
    }


    public static void animationDelay ()
    {
	try
	{
	    Thread.sleep (500);
	}
	catch (InterruptedException ie)
	{
	}
	c.clear ();
    }


    public static void loadDelay ()
    {
	try
	{
	    Thread.sleep (1000);
	}
	catch (InterruptedException ie)
	{
	}
    }


    public static void twoSecDelay ()
    {
	try
	{
	    Thread.sleep (2000);
	}
	catch (InterruptedException ie)
	{
	}
    }


    public static void threeSecDelay ()
    {
	try
	{
	    Thread.sleep (3000);
	}
	catch (InterruptedException ie)
	{
	}
    }


    public static void fiveSecDelay ()
    {
	try
	{
	    Thread.sleep (5000);
	}
	catch (InterruptedException ie)
	{
	}
    }


    public static void graphics ()
    {
	//Scene setup
	c.setColor (lightblue);
	c.fillRect (0, 0, 1000, 1000);
	c.setColor (white);
	c.fillOval (100, 50, 200, 50);
	c.fillOval (350, 50, 200, 50);
	c.setColor (green);
	c.fillRect (0, 450, 1000, 50);

	//Fighter 1 colours
	c.setColor (red);
	c.fillRect (50, 200, 100, 100);
	c.fillRect (75, 300, 50, 100);
	c.fillRect (125, 325, 50, 50);
	c.fillRect (25, 325, 50, 50);
	c.fillRect (125, 400, 50, 50);
	c.fillRect (25, 400, 50, 50);

	//Fighter 2 colours
	c.setColor (blue);
	c.fillRect (487, 200, 100, 100);
	c.fillRect (512, 300, 50, 100);
	c.fillRect (562, 325, 50, 50);
	c.fillRect (462, 325, 50, 50);
	c.fillRect (562, 400, 50, 50);
	c.fillRect (462, 400, 50, 50);

	//Fighters face
	c.setColor (black);
	c.fillRect (70, 220, 20, 20);
	c.fillRect (507, 220, 20, 20);
	c.fillRect (110, 220, 20, 20);
	c.fillRect (547, 220, 20, 20);
	c.fillRect (70, 260, 60, 20);
	c.fillRect (507, 260, 60, 20);

	//Fighters outlines
	c.setColor (black);
	c.drawRect (50, 200, 100, 100);
	c.drawRect (487, 200, 100, 100);
	c.drawRect (75, 300, 50, 100);
	c.drawRect (512, 300, 50, 100);
	c.drawRect (125, 325, 50, 50);
	c.drawRect (562, 325, 50, 50);
	c.drawRect (25, 325, 50, 50);
	c.drawRect (462, 325, 50, 50);
	c.drawRect (125, 400, 50, 50);
	c.drawRect (562, 400, 50, 50);
	c.drawRect (25, 400, 50, 50);
	c.drawRect (462, 400, 50, 50);
    }


    public static void graphicsHook ()
    {
	//Scene setup
	c.setColor (lightblue);
	c.fillRect (0, 0, 1000, 1000);
	c.setColor (white);
	c.fillOval (100, 50, 200, 50);
	c.fillOval (350, 50, 200, 50);
	c.setColor (green);
	c.fillRect (0, 450, 1000, 50);

	//Fighter 1 colours
	c.setColor (red);
	c.fillRect (50, 200, 100, 100);
	c.fillRect (75, 300, 50, 100);
	c.fillRect (125, 325, 50, 50);
	c.fillRect (25, 325, 50, 50);
	c.fillRect (125, 400, 50, 50);
	c.fillRect (25, 400, 50, 50);

	c.setColor (black);
	c.fillRect (70, 220, 20, 20);
	c.fillRect (110, 220, 20, 20);
	c.fillRect (70, 260, 60, 20);

	//c.setColor (black); may not be needed
	c.drawRect (50, 200, 100, 100);
	c.drawRect (75, 300, 50, 100);
	c.drawRect (125, 325, 50, 50);
	c.drawRect (25, 325, 50, 50);
	c.drawRect (125, 400, 50, 50);
	c.drawRect (25, 400, 50, 50);
    }


    public static void victoryGuy ()  //if something goes wrong, fix this method (appears to be working correctly)
    {
	c.fillRect (487, 200, 100, 100);
	c.fillRect (512, 300, 50, 100);
	c.fillRect (562, 325, 50, 50);
	c.fillRect (462, 325, 50, 50);
	c.fillRect (562, 400, 50, 50);
	c.fillRect (462, 400, 50, 50);
	c.setColor (black);
	c.fillRect (507, 220, 20, 20);
	c.fillRect (547, 220, 20, 20);
	c.fillRect (507, 260, 60, 20);
	c.drawRect (487, 200, 100, 100);
	c.drawRect (512, 300, 50, 100);
	c.drawRect (562, 325, 50, 50);
	c.drawRect (462, 325, 50, 50);
	c.drawRect (562, 400, 50, 50);
	c.drawRect (462, 400, 50, 50);
    }


    public static void nukeOverLoad ()
    {
	//INSERT ANIMATIONS HERE LATER

	c.setColor (red);
	c.fillRect (0, 0, 1000, 1000);
	twoSecDelay ();
	c.setColor (blue);
	c.setFont (big);
	c.drawString ("It's a draw, stand down...", 100, 200);
	fiveSecDelay ();
    }


    public static void nukeWarning (int nukeInbound)
    {
	c.setColor (yellow);
	c.setFont (small);
	c.drawString ("WARNING!! Nuke inbound in " + nukeInbound + " turn(s)!", 200, 200);
	threeSecDelay (); //if this is too short, change back to 4 second msg
    }


    public static void HUD (int r, int b, String msg)
    {
	//insert all the other stuff for player 1 here such as his moves and the display of hp and all that other stuff
	c.setFont (small);
	c.drawString (msg, 550, 40);

	//Player 1's HP
	c.setColor (red);
	c.drawString ("" + r, 10, 490);

	//Player 2's HP
	c.setColor (blue);
	c.drawString ("" + b, 590, 490);

	//Attacks and move choices (consider making control first and then what it does ex: Q = Fireball)
	c.setColor (red);
	c.drawString ("Fireball = Q", 10, 20);

	c.setColor (cyan);
	c.drawString ("Icebolt = W", 10, 40);

	c.setColor (orange);
	c.drawString ("Right Hook = E", 10, 60);

	c.setColor (yellow);
	c.drawString ("Tazer = R", 10, 80);

	c.setColor (green);
	c.drawString ("First-Aid = T", 10, 100);
    }


    public static void loadingBar (String one, String two)  //'one' is hint1 and 'two' is hint2
    {
	c.setFont (small);
	c.setColor (red);
	c.drawString (one, 100, 350);
	c.drawString (two, 100, 400);
	c.setColor (black);
	c.drawRect (150, 200, 325, 50);
	c.setColor (green);
	for (int x = 160 ; x < 415 ; x++)
	{
	    c.fillRect (x, 210, 50, 30);
	    gottaGoFast ();
	}
    }


    public static void initializer ()
    {
	c.setTextBackgroundColor (lightblue);
	c.setTextColor (yellow);
	c.setFont (small);
	c.setColor (orange);
	c.drawString ("Guess the number between 1-9 to see who goes first!", 10, 40);
    }
}


