// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import frc.robot.subsystems.SwerveDrivetrain;
import frc.robot.subsystems.DriveOdometrySubsystem;



public class DriveZero extends CommandBase {




   DriveOdometrySubsystem driveOdometrySubsystem;
    public DriveZero() {

       
        addRequirements(driveOdometrySubsystem);
    }

   

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
//        RobotContainer.drive.resetIMU();
//        RobotContainer.drive.resetEncoders();
        driveOdometrySubsystem.resetOdometry(new Pose2d(new Translation2d(0, 0), new Rotation2d(0)));
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}
