// @Service
// public class ServiceEntryServiceImpl implements ServiceEntryService {

//     private final ServiceEntryRepository serviceEntryRepository;

//     public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
//         this.serviceEntryRepository = serviceEntryRepository;
//     }

//     @Override
//     public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
//         return serviceEntryRepository.save(serviceEntry);
//     }

//     @Override
//     public List<ServiceEntry> getAllServiceEntries() {
//         return serviceEntryRepository.findAll();
//     }

//     @Override
//     public Optional<ServiceEntry> getServiceEntryById(Long id) {
//         return serviceEntryRepository.findById(id);
//     }

//     @Override
//     public ServiceEntry updateServiceEntry(Long id, ServiceEntry serviceEntry) {
//         return serviceEntryRepository.save(serviceEntry);
//     }

//     // @Override
//     public void deleteServiceEntry(Long id) {
//         serviceEntryRepository.deleteById(id);
//     }

//     // ✅ REQUIRED BY TEST CASE
//     public List<ServiceEntry> getEntriesForVehicle(long vehicleId) {
//         return serviceEntryRepository.findByVehicleId(vehicleId);
//     }
// }
