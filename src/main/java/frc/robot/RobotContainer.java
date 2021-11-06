// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Subsystem;
//import frc.robot.commands.SwerveDriveCommand;
import frc.robot.subsystems.RonMK1;
//import frc.robot.commands.buttons.ToggleRon;
import frc.robot.commands.shooterCommands.FireOnTrigger;


import java.util.List;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.SwerveDrivetrain;
import frc.robot.commands.SwerveAndLimelight;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static RobotContainer m_instance = null;

  private final XboxController operatorController = new XboxController(1);
  private final JoystickButton operatorBButton = new JoystickButton(operatorController, XboxController.Button.kB.value);
  private final JoystickButton operatorAButton = new JoystickButton(operatorController, XboxController.Button.kA.value);
  private final JoystickButton operatorXButton = new JoystickButton(operatorController, XboxController.Button.kX.value);
  private final JoystickButton operatorLeftBumper = new JoystickButton(operatorController, XboxController.Button.kBumperLeft.value);
  private final JoystickButton operatorStartButton = new JoystickButton(operatorController, XboxController.Button.kStart.value);
  private final JoystickButton operatorSelectButton = new JoystickButton(operatorController, XboxController.Button.kBack.value);
  private final JoystickButton operatorRightBumper = new JoystickButton(operatorController, XboxController.Button.kBumperRight.value);
 
  //Driver Controller and Buttons
  private final XboxController driverController = new XboxController(0);
  private final JoystickButton driverStartButton = new JoystickButton(driverController, XboxController.Button.kStart.value);
  private final JoystickButton driverAbutton = new JoystickButton(driverController, XboxController.Button.kA.value);
  private final XboxController gunnerControls = new XboxController(1);
  private final SwerveDrivetrain drivetrain = new SwerveDrivetrain();

  //private final SwerveAndLimelight swerveAndLimelight = new SwerveAndLimelight(Limedrivetrain);
  private final SwerveAndLimelight swerveAndLimelight = new SwerveAndLimelight(drivetrain);  
  public static RonMK1 ronMK1;

 

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    drivetrain.setDefaultCommand(swerveAndLimelight);

    ronMK1 = new RonMK1();

    
    //.setDefaultCommand(new SwerveAndLimelight(subsystem));

    //limedrivetrain.setDefaultCommand(new SwerveAndLimelight(limedrivetrain, controller));
    //drivetrain.setDefaultCommand(new SwerveDriveCommand(drivetrain, controller));



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
  public boolean reverseIntakeState(){
    return gunnerControls.getXButton();
  }

  public boolean getCharlieState(){
    return driverController.getRawButton(8);
  }
  public boolean getClimberState(){
    return gunnerControls.getBackButton();
  }
  public boolean getReverseClimberState(){
    return gunnerControls.getStartButton();
  }




}



