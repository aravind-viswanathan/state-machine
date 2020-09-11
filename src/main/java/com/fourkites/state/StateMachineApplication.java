package com.fourkites.state;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fourkites.state.action.StateAction;
import com.fourkites.state.action.StateMachine;
import com.fourkites.state.model.State;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fourkites.state.repository")
public class StateMachineApplication implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger(StateMachineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }

    @Autowired
    private StateAction stateAction;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Starting state machine.. ");

        LOG.info("The state machine is in the INITSTATE. Please enter an event");
        final Scanner scanner   = new Scanner(System.in);
        String        stateName = "INITSTATE";
        String        input     = scanner.nextLine();

        while (!input.equalsIgnoreCase("exit")) {

            try {
                var state = stateAction.performAction(stateName, input);
                if(state.getStateName().equalsIgnoreCase("delivered")){
                    LOG.info("The package has been delivered.. starting next item");
                    stateName = "INITSTATE";
                }else{
                    stateName = state.getStateName();
                }
                LOG.info("In state {}, enter next event:", stateName);
            } catch (Exception ex) {
                LOG.error("An invalid state exception was received.. state unchanged {}", stateName);
            } finally {
                input = scanner.nextLine();
            }

        }
        LOG.info("Exiting the program");
    }
}
