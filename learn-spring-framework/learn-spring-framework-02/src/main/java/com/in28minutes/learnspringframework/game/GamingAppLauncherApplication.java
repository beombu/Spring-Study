package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);

        context.getBean(GamingConsole.class).up();

        context.getBean(GameRunner.class).run();
//        var game = new PacmanGame();
        //var game = new MarioGame();
        //var game = new SuperContraGame();
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();
    }
}
