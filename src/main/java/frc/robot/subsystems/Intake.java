package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.annotation.concurrent.GuardedBy;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class Intake extends SubsystemBase{
    private static Intake m_instance;
    TalonSRX _talon3 = new TalonSRX(22);
    Solenoid extendIntake = new Solenoid(1);

    private double IntakePercent = 0.0;

    private final Object stateLock = new Object(); 
    @GuardedBy("intakeState")
    boolean IntakeExtended = false;

    public Intake(){
        super();
        setBrakeMode(true);
    }

    public void update(double time){
        double localMotorOutput;
        boolean localIntakeState; 
        synchronized (stateLock){
            localMotorOutput = IntakePercent;
            localIntakeState = IntakeExtended;
    
    

            }
            _talon3.set(ControlMode.PercentOutput, localMotorOutput);
    
            if (localIntakeState != extendIntake.get()){
                extendIntake.set(localIntakeState);

        }



 

    }


    public static Intake getInstance(){
        if(m_instance == null){
            m_instance = new Intake();

        }
        return m_instance;
    }

    public void ExtendIntake(boolean IntakeState){

        synchronized (stateLock){
            this.IntakeExtended = IntakeState;
        }
    }

    public boolean isIntakeExtended(){
        synchronized (stateLock){
            return IntakeExtended;
        }


    }
    public void RunIntake(double percent){
        _talon3.set(ControlMode.PercentOutput, percent);
    }

    public void setBrakeMode(boolean mode){
        if(mode == true){
            _talon3.setNeutralMode(NeutralMode.Brake);
        }
        else{
            _talon3.setNeutralMode(NeutralMode.Coast);
        }

    }
}