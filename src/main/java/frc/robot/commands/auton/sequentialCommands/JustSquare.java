package frc.robot.commands.auton.sequentialCommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auton.DriveFollowPath;
import frc.robot.subsystems.DriveOdometrySubsystem;

public class JustSquare extends SequentialCommandGroup{

    public JustSquare(){
        super(new DriveFollowPath("squarepath_left"));
    }
    
}
