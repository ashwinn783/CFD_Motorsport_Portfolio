// Simcenter STAR-CCM+ macro: des.java
// Written by Simcenter STAR-CCM+ 18.06.006
package macro;

import java.util.*;
import java.io.File;
import star.common.*;
import star.base.neo.*;

public class des extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

    InnerIterationStoppingCriterion innerIterationStoppingCriterion_0 = ((InnerIterationStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Inner Iterations"));
    PhysicalTimeStoppingCriterion physicalTimeStoppingCriterion_0 = ((PhysicalTimeStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Physical Time"));
    StepStoppingCriterion stepStoppingCriterion_0 = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    innerIterationStoppingCriterion_0.setIsUsed(true);
    physicalTimeStoppingCriterion_0.setIsUsed(true);
    stepStoppingCriterion_0.setIsUsed(true);

    innerIterationStoppingCriterion_0.setIsUsed(false);
    physicalTimeStoppingCriterion_0.setIsUsed(false);
    stepStoppingCriterion_0.setIsUsed(false);

    PhysicsContinuum physicsContinuum_0 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("k-epsilon Lag EB"));

    Region region_0 = simulation_0.getRegionManager().getRegion("Air");
    physicsContinuum_0.add(region_0);

    Region region_1 = simulation_0.getRegionManager().getRegion("MRF-FR");
    physicsContinuum_0.add(region_1);

    Region region_2 = simulation_0.getRegionManager().getRegion("MRF-RR");
    physicsContinuum_0.add(region_2);

    Region region_3 = simulation_0.getRegionManager().getRegion("MRF-FL");
    physicsContinuum_0.add(region_3);

    Region region_4 = simulation_0.getRegionManager().getRegion("MRF-RL");
    physicsContinuum_0.add(region_4);


    stepStoppingCriterion_0.setIsUsed(true);
    IntegerValue integerValue_1 = stepStoppingCriterion_0.getMaximumNumberStepsObject();
    integerValue_1.getQuantity().setValue(3000.0);
    
    simulation_0.getSimulationIterator().run();

    PhysicsContinuum physicsContinuum_1 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("DES"));

    physicsContinuum_1.add(region_0);
    physicsContinuum_1.add(region_1);
    physicsContinuum_1.add(region_2);
    physicsContinuum_1.add(region_3);
    physicsContinuum_1.add(region_4);


    stepStoppingCriterion_0.setIsUsed(false);

    physicalTimeStoppingCriterion_0.setIsUsed(true);
    Units units_0 = ((Units) simulation_0.getUnitsManager().getObject("s"));
    physicalTimeStoppingCriterion_0.getMaximumTime().setValueAndUnits(1.0, units_0);
    
    innerIterationStoppingCriterion_0.setIsUsed(true);
    IntegerValue integerValue_0 = innerIterationStoppingCriterion_0.getMaxIterations();
    integerValue_0.getQuantity().setValue(10.0);


    ImplicitUnsteadySolver implicitUnsteadySolver_0 = ((ImplicitUnsteadySolver) simulation_0.getSolverManager().getSolver(ImplicitUnsteadySolver.class));
    Units units_1 = ((Units) simulation_0.getUnitsManager().getObject("s"));
    implicitUnsteadySolver_0.getTimeStep().setValueAndUnits(5E-5, units_1);

    simulation_0.getSimulationIterator().run();

    String FileName = simulation_0.getPresentationName();
    simulation_0.saveState(resolvePath(FileName + ".sim"));

  }
}
