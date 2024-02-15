package coroutine

/**
 * < 프로세스-스레드 와 스레드-코루틴 의 차이 >
 *
 * - 프로세스-스레드 : 스레드는 프로세스에 종속됨. 다른 프로세스로 옮겨갈 수 X
 * - 스레드-코루틴 : 코루틴의 코드가 실행되려면, 스레드가 있어야 한다 (코루틴의 코드가 스레드로 넘어가 처리됨)
 *                  but 중단 되었다 재개될 때 다른 스레드에 배정될 수 있다 (코루틴은 스레드에 종속되지 않음)
 *
 *
 * - 프로세스 context switching : 프로세스가 바뀌면 메모리가 교체되어야 함 -> 비용이 많이 듦
 *
 * - 스레드 context switchig : 같은 프로세스 내 Heap 메모리를 공유하고 Stack 메모리만 교체되므로 프로세스보다는 비용이 적게 듦
 *
 * - 코루틴 context switching : 동일 스레드에서 코루틴이 실행되면, 메모리를 전부 공유하므로 스레드보다 context switching cost가 낮다
 *          => 하나의 스레드에서 여러 코루틴이 동시에 실행되는 것처럼 보인다 -> 하나의 스레드에서 '동시성' 을 확보할 수 있다
 *     * 동시성 : 한 번에 한 가지 일만 할 수 있지만 아주 빠르게 작업이 전환되어 동시에 하는 것 처럼 보이는 것
 *        <-> 병렬성 : 실제로 2가지 일을 동시에 하는 것 (CPU multi-core)
 *
 *
 *  - 코루틴은 yield() 로 스스로 자리를 양보할 수 있음(=비선점형)
 *  - 스레드는 os가 개입해서 자리를 비켜지게 됨(=선점형)
 */