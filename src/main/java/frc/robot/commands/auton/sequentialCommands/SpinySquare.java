package frc.robot.commands.auton.sequentialCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auton.DriveFollowPath;

public class SpinySquare extends SequentialCommandGroup{
    public SpinySquare(){
        super(new DriveFollowPath("squareSpinyPath_left"));
    }
    
}
