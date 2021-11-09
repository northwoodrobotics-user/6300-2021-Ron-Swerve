package frc.robot.commands.auton.Autogroups;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;
import frc.robot.commands.auton.DriveFollowPath;
import frc.robot.commands.intakeCommands.AutoUseIntake;
import frc.robot.subsystems.Intake;



public class DriveAndEat extends ParallelDeadlineGroup{



    public DriveAndEat(String path, double speed){
        super(
            new DriveFollowPath(path),
           new AutoUseIntake(speed)


        );
    }
    
}
