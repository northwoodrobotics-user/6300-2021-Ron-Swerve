// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;



import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Pose2d;

public class SwerveDrivetrain extends SubsystemBase {



  public static double deadBand(double input) {
		double output;
		double radius = 0.05;
		assert (-1 <= input && input <= 1) : "input is less than -1 or greater than 1";
		assert (radius < 1) : "deadband radius is greater than or equal to the maximum output";

		if (input >= radius) {
			output = ((1 * (input - 1)) / (1 - radius)) + 1;
		} else if (input < -radius) {
			output = ((1 * (input + 1)) / (1 - radius)) - 1;
		} else {
			output = 0;
		}

		assert (Math.abs(output) <= 1) : "expected to output a smaller number than the 1 of " + 1;
		return output;
	}


  //these are limits you can change!!!
  public static final double kMaxSpeed = Units.feetToMeters(2); // 20 feet per second
  public static final double kMaxAngularSpeed = Math.PI/2; // 1/2 rotation per second
  public static double fieldCalibration = 0;

  //this is where you put the angle offsets you got from the smart dashboard

  public static double frontLeftOffset = -166;
  public static double frontRightOffset = -298;
  public static double backLeftOffset = -250;
  public static double backRightOffset = -127;


  //put your can Id's here!
  public static final int frontLeftDriveId = 15;    
  public static final int frontLeftCANCoderId = 4; 
  public static final int frontLeftSteerId = 9;
  //put your can Id's here!
  public static final int frontRightDriveId = 13; 
  public static final int frontRightCANCoderId = 3; 
  public static final int frontRightSteerId = 8; 
  //put your can Id's here!
  public static final int backLeftDriveId = 10; 
  public static final int backLeftCANCoderId = 2; 
  public static final int backLeftSteerId = 14;
  //put your can Id's here!

  public static final int backRightDriveId = 12; 
  public static final int backRightCANCoderId = 1; 
  public static final int backRightSteerId = 16;   
  public static AHRS m_gyro = new AHRS(SPI.Port.kMXP);


  //creating objects for swerve

  private static SwerveDrivetrain m_instance;





  Translation2d m_frontLeftLocation = new Translation2d(
    Units.inchesToMeters(15),
    Units.inchesToMeters(15)
  );
  Translation2d m_frontRightLocation = new Translation2d(
    Units.inchesToMeters(15),
    Units.inchesToMeters(-15)
  );
Translation2d m_backLeftLocation = new Translation2d(
  Units.inchesToMeters(-15),
  Units.inchesToMeters(15)
);
Translation2d m_backRightLocation = new Translation2d(
  Units.inchesToMeters(-15),
  Units.inchesToMeters(-15)
);


private final SwerveModuleMK3 m_frontLeftModuleMK3 = new SwerveModuleMK3(new TalonFX(frontLeftDriveId), new TalonFX(frontLeftSteerId), new CANCoder(frontLeftCANCoderId), Rotation2d.fromDegrees(frontLeftOffset));
private final SwerveModuleMK3 m_frontRightModuleMK3 = new SwerveModuleMK3(new TalonFX(frontRightDriveId), new TalonFX(frontRightSteerId), new CANCoder(frontRightCANCoderId), Rotation2d.fromDegrees(frontRightOffset));
private final SwerveModuleMK3 m_backLeftModuleMK3 = new SwerveModuleMK3(new TalonFX(backLeftDriveId), new TalonFX(backLeftSteerId), new CANCoder(backLeftCANCoderId), Rotation2d.fromDegrees(backLeftOffset));
private final SwerveModuleMK3 m_backRightModuleMK3 =  new SwerveModuleMK3(new TalonFX(backRightDriveId), new TalonFX(backRightSteerId), new CANCoder(backRightCANCoderId), Rotation2d.fromDegrees(backRightOffset));




  
	public double getGyroHeading() {
		return m_gyro.getAngle() % 360;
  } 
  




  private SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics( 
    m_frontLeftLocation, 
  m_frontRightLocation,
   m_backLeftLocation, 
   m_backRightLocation

  );

  private

 SwerveDriveOdometry m_odometry = new SwerveDriveOdometry(m_kinematics, 
 m_gyro.getRotation2d(), 
 new Pose2d(5.0,13.5, new Rotation2d() )
 );
 

  private SwerveModuleMK3[] modules = new SwerveModuleMK3[] {

   m_frontLeftModuleMK3,
   m_frontRightModuleMK3,
   m_backLeftModuleMK3,
   m_backRightModuleMK3 };

  public SwerveDrivetrain() {
   // gyro.reset(); 


  }

  /**
   * Method to drive the robot using joystick info.
   *
   * @param xSpeed Speed of the robot in the x direction (forward).
   * @param ySpeed Speed of the robot in the y direction (sideways).
   * @param rot Angular rate of the robot.
   * @param fieldRelative Whether the provided x and y speeds are relative to the field.
   * @param calibrateGyro button to recalibrate the gyro offset
   */
  public void Drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative, boolean calibrateGyro) {

    
    if(calibrateGyro){
      m_gyro.reset(); //recalibrates gyro offset
    }

    SwerveModuleState[] states =
      m_kinematics.toSwerveModuleStates(

      
        fieldRelative
          ? ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rot, Rotation2d.fromDegrees(-m_gyro.getAngle()))
          : new ChassisSpeeds(xSpeed, ySpeed, rot));
    SwerveDriveKinematics.normalizeWheelSpeeds(states, kMaxSpeed);
    for (int i = 0; i < states.length; i++) {
      SwerveModuleMK3 module = modules[i];
      SwerveModuleState state = states[i];
      SmartDashboard.putNumber(String.valueOf(i), module.getRawAngle());
      //below is a line to comment out from step 5
      module.setDesiredState(state);
      SmartDashboard.putNumber("gyro Angle", m_gyro.getAngle());
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    var gyroAngle =Rotation2d.fromDegrees(-m_gyro.getAngle());

  }
  public void updateOdometry() {
    m_odometry.update(
        m_gyro.getRotation2d(),
        m_frontLeftModuleMK3.getState(),
        m_frontRightModuleMK3.getState(),
        m_backLeftModuleMK3.getState(),
        m_backRightModuleMK3.getState()
        
    );
      
        
  }

  public Pose2d getPose(){
    return m_odometry.getPoseMeters();
  }

  public void resetOdometry(Pose2d pose) {
    m_odometry.resetPosition(pose, m_gyro.getRotation2d());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


}
