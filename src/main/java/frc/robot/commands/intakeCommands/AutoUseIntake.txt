package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;

public class AutoUseIntake extends CommandBase{

    private double speed;
    Intake intake;

    public AutoUseIntake(double speed){
        this.speed = speed;
        addRequirements(intake);



        
    }

    @Override
    public void initialize() 
    {
  
    }

    @Override
    public void execute(){
        intake.RunIntake(speed);
    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return true;
    }



    
}
