package frc.robot.commands.auton.autonShooter;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.RonMK1;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.SwerveDrivetrain;

public class AutoShoot extends CommandBase{

    RonMK1 ronMK1;
    Intake intake;
    SwerveDrivetrain swerveDrivetrain;
    Timer timer = new Timer();


    public AutoShoot(RonMK1 shooter,Intake feeder, SwerveDrivetrain drivetrain){
        ronMK1 = shooter;
        intake = feeder;
        swerveDrivetrain = drivetrain;
        addRequirements(ronMK1, intake, swerveDrivetrain);

    }
    @Override
    public void initialize(){
        timer.start();
        ronMK1.FireRon(1);

    }

    @Override
    public void execute(){
        swerveDrivetrain.xMode();
        if (timer.get() > .5){
            intake.RunIntake(.5);
        }
        
    }
    @Override
    public void end(boolean interrupted){
        ronMK1.FireRon(0);
        intake.RunIntake(0);
    }
    @Override
    public boolean isFinished(){
        return timer.get() > 4;
    }









    
}
