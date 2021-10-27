// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.SwerveDriveCommand;

import frc.robot.subsystems.SwerveDrivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static RobotContainer m_instance = null;

  private final XboxController controller = new XboxController(0);
  private final XboxController gunnerControls = new XboxController(1);


  

  private final SwerveDrivetrain drivetrain = new SwerveDrivetrain();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {


    drivetrain.setDefaultCommand(new SwerveDriveCommand(drivetrain, controller));



  }
  public static RobotContainer getInstance(){
    if (m_instance == null){
      m_instance = new RobotContainer();
    }
    return m_instance;
  }
  public boolean getRonState() {
    return gunnerControls.getAButton();
  }

  public boolean getIntakeState(){
    return gunnerControls.getBButton();
  }




}


