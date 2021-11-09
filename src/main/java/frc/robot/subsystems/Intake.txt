package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class Intake extends SubsystemBase{
    private static Intake m_instance;
    TalonSRX _talon3 = new TalonSRX(22);

    public Intake(){
        super();
        setBrakeMode(true);
    }


    public static Intake getInstance(){
        if(m_instance == null){
            m_instance = new Intake();

        }
        return m_instance;
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