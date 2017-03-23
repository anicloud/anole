import com.ani.anole.Anole;
import com.ani.anole.domain.state.State;
import com.ani.anole.domain.state.StateGroup;
import com.ani.anole.domain.state.StateProperty;
import com.ani.anole.domain.statemachine.StateMachine;
import com.ani.anole.domain.statemachine.StateMachineNode;
import com.ani.anole.domain.statemachine.StateObject;
import org.junit.Test;

import java.util.*;

/**
 * Created by zsl on 17-3-23.
 */
public class TestAnole {
    Anole anole;

    private void initAnole() {
        Set<String> tags = new HashSet();
        tags.add(new String("light"));
        tags.add(new String("ani"));
        StateGroup stateGroup = new StateGroup(1L, "light", tags);
        StateProperty stateProperty = new StateProperty(new com.ani.utils.core.datatype.AniDataType(com.ani.utils.core.datatype.AniDataTypeCategories.PRIMITIVE, com.ani.utils.core.datatype.AniDataPrimitiveTypes.FLOAT), "lux");
        List properties = new ArrayList();
        properties.add(stateProperty);
        State state = new State(stateGroup, 1, "lightOn", properties);
        State state1 = new State(stateGroup, 2, "lightOff", properties);

        StateMachineNode stateMachineNode = new StateMachineNode(state, null, null);
        StateMachineNode currentnode = new StateMachineNode(state1, null, null);
        Set<StateMachineNode> stateMachineNodes = new HashSet<>();
        stateMachineNodes.add(stateMachineNode);
        stateMachineNodes.add(currentnode);

        String stateObjectId = "11:1";
        Long timestamp = System.currentTimeMillis();

        Map<Integer, StateMachine> stateMachineIdMap = new HashMap<>();
        StateMachine stateMachine = new StateMachine(1, stateMachineNodes, stateMachineNode);
        stateMachineIdMap.put(stateMachine.smId, stateMachine);

        StateObject stateObject = new StateObject(stateObjectId, stateMachineIdMap, timestamp);

        Map<String, StateObject> stateObjectMap = new HashMap<>();
        stateObjectMap.put(stateObjectId, stateObject);
        anole = new Anole(stateObjectMap);
    }
    @Test
    public void test(){
        initAnole();
       StateObject stateObject = anole.getStateObject("11:1");
        System.out.print(stateObject.stateObjectId);
    }
}
