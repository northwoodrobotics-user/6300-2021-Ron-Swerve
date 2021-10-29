package frc.robot.commands;



import frc.robot.subsystems.SwerveDrivetrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.SlewRateLimiter;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class SwerveAndLimelight extends CommandBase{
    XboxController controller; 
    XboxController gunnerControls;
  

     SwerveDrivetrain drivetrain;
    boolean limeLightarmed = false;

    NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry horizontalEntry;


     SlewRateLimiter xspeedLimiter = new SlewRateLimiter(1);
     SlewRateLimiter yspeedLimiter = new SlewRateLimiter(1);
     SlewRateLimiter rotLimiter = new SlewRateLimiter(1);
    double horizontal;

    public SwerveAndLimelight(SwerveDrivetrain limeswerve) 
      {
        this.drivetrain = limeswerve;
        addRequirements(drivetrain);
        
    }



    @Override
    public void execute() {
       final var xSpeed = -xspeedLimiter.calculate(SwerveDrivetrain.deadBand(controller.getY(GenericHID.Hand.kLeft)))
        * SwerveDrivetrain.kMaxSpeed;



       final var ySpeed = yspeedLimiter.calculate(SwerveDrivetrain.deadBand(controller.getX(GenericHID.Hand.kLeft)))
        * SwerveDrivetrain.kMaxSpeed;
        
        
        
        double rot = 0;


        if (controller.getBumper(Hand.kLeft)) {
            limelightTable.getEntry("ledMode").forceSetNumber(3);

            //find the center of target
            horizontalEntry = limelightTable.getEntry("tx");
            horizontal = horizontalEntry.getDouble(0);
            horizontal = horizontal - 2.9/* + limelightTable.getEntry("thor").getDouble(0) / 15*/;
            
            
            rot = horizontal / 23.0;
            rot = rot - rot * 0.55;
            if (rot > 0.2)
            {
              rot = 0.2;
            }
            else if (rot < -0.2)
            {
              rot = -0.2;
            }
            
            if (Math.abs(rot) <= 0.015)
            {
              rot = 0;
      
          }
          else  {

            if (limelightTable.getEntry("ledMode").getDouble(0) == 3)
            {
              limelightTable.getEntry("ledMode").forceSetDouble(1);
            }
      
            rot = -rotLimiter.calculate(SwerveDrivetrain.deadBand(controller.getX(GenericHID.Hand.kRight)))
            * SwerveDrivetrain.kMaxAngularSpeed*.6;
            
            // SmartDashboard.putNumber("X Box X-Axis", directionX);
            // SmartDashboard.putNumber("X Box Y-Axis", directionY);
            // SmartDashboard.putNumber("X Box Rotation", rotation);
      
            //drive normally with joysticks
            this.drivetrain.Drive(xSpeed, ySpeed, rot, true, false);
          }
      
      
        }
        




        
    }
    public boolean isFinished() {
        return false;
      }
}
