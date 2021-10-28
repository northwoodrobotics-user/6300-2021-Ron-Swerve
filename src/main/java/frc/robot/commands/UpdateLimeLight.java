
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class UpdateLimeLight extends InstantCommand {
  public UpdateLimeLight() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Limelight.getInstance());
  }

  // Called just before this Command runs the first time
  @Override
 public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    frc.robot.subsystems.Limelight.getInstance().setLimelightData();
    frc.robot.subsystems.Limelight.getInstance().getLimelightData();
  
  }
}

  // Make this return true when this Command no longer needs to run execute()
  



