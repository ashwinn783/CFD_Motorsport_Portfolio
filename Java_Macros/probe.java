package macro;

import java.util.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class probe extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

    // Define probe coordinates
    double[][] coordinates = {
      {250, -400, 885}, {250, -350, 885}, {250, -300, 885}, {250, -250, 885}, {250, -200, 885},
      {250, -150, 885}, {250, -100, 885}, {250, -50, 885}, {250, 0, 885}, {250, 50, 885},
      {250, 100, 885}, {250, 150, 885}, {250, 200, 885}, {250, 250, 885}, {250, 300, 885},
      {250, 350, 885}, {250, 400, 885}, {250, -325, 810}, {250, -275, 810}, {250, -225, 810},
      {250, -175, 810}, {250, -125, 810}, {250, -75, 810}, {250, -25, 810}, {250, 25, 810},
      {250, 75, 810}, {250, 125, 810}, {250, 175, 810}, {250, 225, 810}, {250, 275, 810},
      {250, 325, 810}, {250, -400, 735}, {250, -350, 735}, {250, -300, 735}, {250, -250, 735},
      {250, -200, 735}, {250, -150, 735}, {250, -100, 735}, {250, -50, 735}, {250, 0, 735},
      {250, 50, 735}, {250, 100, 735}, {250, 150, 735}, {250, 200, 735}, {250, 250, 735},
      {250, 300, 735}, {250, 350, 735}, {250, 400, 735}, {1225, 680, 310}, {1225, 680, 160},
      {1225, 605, 235}, {1225, 530, 310}, {1225, 530, 160}, {1225, 455, 235}, {1225, 380, 310},
      {1225, 380, 160}, {2167.85, 150, 690.15}, {2119.05, 150, 548.33}, {2143.47, 75, 619.25},
      {2167.85, 0, 690.15}, {2119.05, 0, 548.33}, {2143.47, -75, 619.25}, {2167.85, -150, 690.15},
      {2119.05, -150, 548.33}
    };

    // Load specific regions and boundaries
    Region region_0 = simulation_0.getRegionManager().getRegion("Air");
    Boundary boundary_0 = region_0.getBoundaryManager().getBoundary("floor");
    Boundary boundary_1 = region_0.getBoundaryManager().getBoundary("Frontwing");
    Boundary boundary_2 = region_0.getBoundaryManager().getBoundary("inlet");
    Boundary boundary_3 = region_0.getBoundaryManager().getBoundary("mono");
    Boundary boundary_4 = region_0.getBoundaryManager().getBoundary("outlet");
    Boundary boundary_5 = region_0.getBoundaryManager().getBoundary("Rearwing");
    Boundary boundary_6 = region_0.getBoundaryManager().getBoundary("Remaining");
    Boundary boundary_7 = region_0.getBoundaryManager().getBoundary("Undertray");
    Boundary boundary_8 = region_0.getBoundaryManager().getBoundary("Walls");
    Boundary boundary_9 = region_0.getBoundaryManager().getBoundary("wheel-fl");
    Boundary boundary_10 = region_0.getBoundaryManager().getBoundary("wheel-fr");
    Boundary boundary_11 = region_0.getBoundaryManager().getBoundary("wheel-rl");
    Boundary boundary_12 = region_0.getBoundaryManager().getBoundary("wheel-rr");

    Region region_1 = simulation_0.getRegionManager().getRegion("MRF-FL");
    Boundary boundary_13 = region_1.getBoundaryManager().getBoundary("Default");
    Boundary boundary_14 = region_1.getBoundaryManager().getBoundary("wheelhub");

    Region region_2 = simulation_0.getRegionManager().getRegion("MRF-FR");
    Boundary boundary_15 = region_2.getBoundaryManager().getBoundary("Default");
    Boundary boundary_16 = region_2.getBoundaryManager().getBoundary("wheelhub");

    Region region_3 = simulation_0.getRegionManager().getRegion("MRF-RL");
    Boundary boundary_17 = region_3.getBoundaryManager().getBoundary("Default");
    Boundary boundary_18 = region_3.getBoundaryManager().getBoundary("wheelhub");

    Region region_4 = simulation_0.getRegionManager().getRegion("MRF-RR");
    Boundary boundary_19 = region_4.getBoundaryManager().getBoundary("Default");
    Boundary boundary_20 = region_4.getBoundaryManager().getBoundary("wheelhub");

    List<NamedObject> inputParts = Arrays.asList(
      region_0, boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6,
      boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12,
      region_1, boundary_13, boundary_14,
      region_2, boundary_15, boundary_16,
      region_3, boundary_17, boundary_18,
      region_4, boundary_19, boundary_20
    );

    Units units_0 = ((Units) simulation_0.getUnitsManager().getObject("mm"));

    // Create one probe per coordinate
    for (int i = 0; i < coordinates.length; i++) {
      double[] coord = coordinates[i];
      PointPart point = simulation_0.getPartManager().createPointPart(
        new ArrayList<>(inputParts),
        new DoubleVector(coord),
        null
      );
      point.setPresentationName("Probe_" + i);
      point.getInputParts().setQuery(null);
      point.getInputParts().setObjects(inputParts);
      point.getPointCoordinate().setCoordinate(units_0, units_0, units_0, new DoubleVector(coord));
    }
  }
}
