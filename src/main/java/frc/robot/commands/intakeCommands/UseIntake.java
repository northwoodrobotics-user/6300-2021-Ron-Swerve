package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;

public class UseIntake extends CommandBase{ 
    Intake intake; 
    XboxController operatorController = new XboxController(Constants.OperatorControl.operatorControllerPort);



    public UseIntake(Intake subsystem){

        intake = subsystem;

        addRequirements(intake);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() 
    {
      double intakeSpeed = operatorController.getRawAxis(Constants.OperatorControl.operatorLeftTrigger);
      
      intake.RunIntake(intakeSpeed);
    }

    public void end(boolean interrupted) 
    {
  
      intake.RunIntake(0);
    
    }

    @Override
    public boolean isFinished() {
      return false;
    }


  

    
}
