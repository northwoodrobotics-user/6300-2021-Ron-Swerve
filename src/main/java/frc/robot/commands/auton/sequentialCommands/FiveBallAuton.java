package frc.robot.commands.auton.sequentialCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auton.Autogroups.DriveAndEat;
import frc.robot.commands.auton.autonShooter.AutoShoot;
import frc.robot.subsystems.SwerveDrivetrain;
import frc.robot.subsystems.RonMK1;
import frc.robot.subsystems.Intake;

public class FiveBallAuton extends SequentialCommandGroup{

    public FiveBallAuton(){
        super(
            new DriveAndEat("3trenchBall", 1), 
            new AutoShoot()
        );
    }
    
}
