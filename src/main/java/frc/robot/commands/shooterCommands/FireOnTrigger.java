package frc.robot.commands.shooterCommands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.subsystems.RonMK1;


public class FireOnTrigger extends CommandBase{


    private final XboxController operatorController = new XboxController(Constants.OperatorControl.operatorControllerPort);


    RonMK1 ronMK1;

    boolean firstShot = true; 

    public FireOnTrigger(RonMK1 shooter){
        ronMK1 = shooter;
        addRequirements(ronMK1);
    }

    @Override
    public void initialize() 
    {
  
      SmartDashboard.putNumber("Shooting Speed", 12000);
  
      firstShot = true;
  
      /*try
      {
        SmartDashboard.getNumber("Shooting Speed", 0.28);
      }
      catch (Exception e)
      {
        SmartDashboard.putNumber("Shooting Speed", 0);
      }*/
  
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {
      //get index of seen area
      // int index = (int)shooterSubsystem.getDistance(shooterSubsystem.getVertical());
  
      // //report index to the screen
      // SmartDashboard.putNumber("Array Index", index);
      
      // if (index < shooterSubsystem.speeds.length - 1)
      // {
      //   //if index is inside the size of speeds array set speed to set speed
      //   autoShooterSpeed = shooterSubsystem.speeds[index];
      // }
      // else
      // {
      //   //if not in array size set to standard speed
      //   autoShooterSpeed = 0.65;
      // }
  
      // autoShooterSpeed = SmartDashboard.getNumber("Shooting Speed", 12000);
  
      // double subtractedValue = (1 / shooterSubsystem.getHorizontal());
  
      // //System.out.println(subtractedValue);
  
      // autoShooterSpeed = autoShooterSpeed - subtractedValue;
  
      // autoShooterSpeed = shooterSubsystem.getShootVelocity();
  
      //ronMK1.displayEncoders();
  
      if (operatorController.getRawAxis(Constants.OperatorControl.operatorRightTrigger) > 0.2)
      {
        //if trigger is held shoot at desired speed
        //shooterSubsystem.shoot(autoShooterSpeed, autoShooterSpeed * 1.75, autoShooterSpeed * 1.755);
        // shooterSubsystem.SpinToSpeed(autoShooterSpeed);
  
        if (firstShot)
        {
          //shooterSubsystem.enableLimelight();
          ronMK1.FireRon(1);
          firstShot = false;
        }
        // else
        // {
        //   shooterSubsystem.disableLimelight();
        // }
    
      }
      else
      {
        //shooterSubsystem.disableLimelight();
        //else reset to 0 motor speed
        ronMK1.FireRon(0);
        firstShot = true;
      }
  
      /*SmartDashboard.putNumber("Array Index", autoShooterSpeed);
      
      if (operatorController.getRawAxis(Constants.XboxAxixMapping.operatorLeftTrigger) > 0.2)
      {
        double shootSpeed = SmartDashboard.getNumber("Shooting Speed", 0);
        shooterSubsystem.shoot(shootSpeed, shootSpeed, shootSpeed);
      }
      else
      {
        shooterSubsystem.shoot(0, 0, 0);
      }*/
  
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) 
    {
  
      ronMK1.FireRon(0);
      firstShot = true;
  
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }
  



    

