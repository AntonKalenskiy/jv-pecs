package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {
    private List<? extends Machine> bulldozers = new BulldozerProducer().get();
    private List<? extends Machine> excavators = new ExcavatorProducer().get();
    private List<? extends Machine> trucks = new TruckProducer().get();

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            return new ArrayList<>(bulldozers);
        }
        if (type == Excavator.class) {
            return new ArrayList<>(excavators);
        }
        if (type == Truck.class) {
            return new ArrayList<>(trucks);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> list) {
        for (Machine machine : list) {
            machine.doWork();
        }
    }
}
