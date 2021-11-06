

package frc.robot;

import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.util.Units;


public final class Constants {

    
    public static final class DriveSubsystem {

        public static final double kSwerveTwistPIDTolerance = 10;
        public static final double kSwerveTwistPID_P = 1.0;
        public static final double kSwerveTwistPID_I = 0;
        public static final double kSwerveTwistPID_D = 0;

        public static final double kSwerveDrivePIDTolerance = 10;
        public static final double kSwerveDrivePID_P = 0;
        public static final double kSwerveDrivePID_I = 0;
        public static final double kSwerveDrivePID_D = 0;
        public static final double kSwerveDrivePID_F = 0.052;

        public static final double kMaxTwistAngularVelocity = 360; // deg/s
        public static final double kMaxTwistAngularAcceleration = 360; // deg/s^2

        public static final double kGearRatioMotorToWheel = 6.64; // 6.64 motor rotations = 1 wheel rotation
        public static final double kWheelDiameter = Units.inchesToMeters(1.5); // in meters
        public static final double kMotorEncoderTicksPerRev = 4096;
        public static final double kMotorEncoderTimeUnit = 0.100; // 100ms

        //kPXController

        public static final boolean kGyroReversed = true;

        public static final double kWheelBase = Units.inchesToMeters(28);  // in meters. = 23 inches
        public static final double kTrackWidth = Units.inchesToMeters(28); // in meters. = 22 inches

        public static final double kMaxSpeedMetersPerSecond = 2.5;

        public static final double kMaxAccelerationMetersPerSecondSquared = 1; // yeet

        // Define the order of the swerve modules.
        public static final SwerveDriveKinematics kDriveKinematics =
        new SwerveDriveKinematics(
          new Translation2d(Constants.DriveSubsystem.kWheelBase / 2, Constants.DriveSubsystem.kTrackWidth / 2),
          new Translation2d(Constants.DriveSubsystem.kWheelBase / 2, -Constants.DriveSubsystem.kTrackWidth / 2),
          new Translation2d(-Constants.DriveSubsystem.kWheelBase / 2, Constants.DriveSubsystem.kTrackWidth / 2),
          new Translation2d(-Constants.DriveSubsystem.kWheelBase / 2, -Constants.DriveSubsystem.kTrackWidth / 2));

        public static final int kFrontLeftDriveMotorCanID = 15; //
        public static final int kFrontRightDriveMotorCanID = 13; //
        public static final int kRearRightDriveMotorCanID = 12; //
        public static final int kRearLeftDriveMotorCanID = 10; //

        public static final int kFrontLeftTwistMotorCanID = 9; //
        public static final int kFrontRightTwistMotorCanID = 8; //
        public static final int kRearRightTwistMotorCanID = 16; //
        public static final int kRearLeftTwistMotorCanID = 14; //

        public static final int kFrontLeftEncoderID = 4;
        public static final int kRearLeftEncoderID = 2;
        public static final int kFrontRightEncoderID = 3;
        public static final int kRearRightEncoderID = 1;

        public static final double kFrontLeftEncoderOffset = -166; //
        public static final double kRearLeftEncoderOffset = -298; //
        public static final double kFrontRightEncoderOffset = -250; //
        public static final double kRearRightEncoderOffset = -127; //
    }
    public final class DriverControl {
        public static final int driverControllerPort = 0;
        public static final int driverControllerLeftStickXAxis = 0;
        public static final int driverControllerLeftStickYAxis = 1;
        public static final int driverControllerRightStickXAxis = 4;
        public static final int driverControllerRightStickYAxis = 5;
        public static final int driverControllerRightTriggerAxis = 3;
        public static final int driverControllerLeftTriggerAxis = 2;
    }

    public final class OperatorControl {
        public static final int operatorControllerPort = 1;
        public static final int operatorRightTrigger = 3;
        public static final int operatorLeftTrigger = 2;

        public static final int operatorControllerLeftStickYAxis = 1;
        public static final int operatorControllerRightStickYAxis = 5;
    }

}