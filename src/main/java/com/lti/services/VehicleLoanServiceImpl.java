package com.lti.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.dao.AddressRepository;
import com.lti.dao.ApplicantRepository;
import com.lti.dao.LoanRepository;
import com.lti.dao.UserRepository;
import com.lti.dao.VehicleRepository;
import com.lti.entity.Address;
import com.lti.entity.Applicant;
import com.lti.entity.Loan;
import com.lti.entity.User;
import com.lti.entity.Vehicle;

@Service
public class VehicleLoanServiceImpl implements VehicleLoanService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ApplicantRepository applicantRepo;
	@Autowired
	private VehicleRepository vehicleRepo;
	@Autowired
	private LoanRepository loanRepo;
	@Autowired
	private AddressRepository addressRepo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public User registerUser(User user) {
		if(user.getUserId() > 0) {
			userRepo.save(user);
			return user;
		}
		return null;
	}
	
	@Transactional
	@Override
	public User updateUser(int id, User user) {
		userRepo.save(user);
		return user;
	}
	
	@Override
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	
	@Override
	public List<User> viewAllUser() {
		return userRepo.findAll();
	}
	
	@Transactional
	@Override
	public Applicant registerApplicant(Applicant applicant) {
		applicantRepo.save(applicant);
		return applicant;
	}
	
	@Override
	public List<Applicant> viewAllApplicant() {
		return applicantRepo.findAll();
	}
	
	@Override
	public Optional<Applicant> getApplicantById(int id) {
		return applicantRepo.findById(id);
	}
	
	@Override
	public List<Applicant> getApplicantByUserId(int userId) {
		return applicantRepo.findByUserId(userId);
	}
	
	@Transactional
	@Override
	public Applicant updateApplicant(int applicantId, Applicant applicant) {
		applicantRepo.save(applicant);
		return applicant;
	}
	
	@Override
	@Transactional
	public Applicant deleteApplicant(int applicantId) {
		Optional<Applicant> findApplicant = applicantRepo.findById(applicantId);
		Applicant applicant = null;
		if (findApplicant.isPresent()) {
			applicant = findApplicant.get();
			applicantRepo.delete(applicant);
		} 
		return applicant;
	}
	
	@Transactional
	@Override
	public Address addApplicantAddress(@RequestBody Address applicantAddress) {
		addressRepo.save(applicantAddress);
		return applicantAddress;
	}
	
	@Transactional
	@Override
	public Address updateApplicantAddress(int addressId, Address address) {
		addressRepo.save(address);
		return address;
	}
	
	@Override
	public Optional<Address> getAddressById(int id) {
		return addressRepo.findById(id);
	}
	
	@Override
	public List<Address> getAddressByUserId(int userId) {
		return addressRepo.findByUserId(userId);
	}
	
	@Override
	public List<Address> viewAllAddress() {
		return addressRepo.findAll();
	}
	
	@Override
	@Transactional
	public Address deleteAddress(int addressId) {
		Optional<Address> findAddress = addressRepo.findById(addressId);
		Address address = null;
		if (findAddress.isPresent()) {
			address = findAddress.get();
			addressRepo.delete(address);
		} 
		return address;
	}
	
	@Transactional
	@Override
	public Loan addLoanDetails(@RequestBody Loan loanDetails) {
		loanRepo.save(loanDetails);
		return loanDetails;
	}
	
	@Override
	public List<Loan> viewAllLoans() {
		return loanRepo.findAll();
	}
	
	@Transactional
	@Override
	public Loan updateLoanDetails(int loanId, Loan loan) {
		loanRepo.save(loan);
		return loan;
	}
	
	@Override
	public Optional<Loan> getLoanById(int loanId) {
		return loanRepo.findById(loanId);
	}
	
	@Override
	public List<Loan> getLoanByUserId(int userId) {
		return loanRepo.findByUserId(userId);
	}
	
	@Override
	@Transactional
	public Loan deleteLoan(int loanId) {
		Optional<Loan> findLoan = loanRepo.findById(loanId);
		Loan loan = null;
		if (findLoan.isPresent()) {
			loan = findLoan.get();
			loanRepo.delete(loan);
		} 
		return loan;
	}
	
	@Transactional
	@Override
	public Vehicle addVehicleDetails(@RequestBody Vehicle vehicleDetails) {
		vehicleRepo.save(vehicleDetails);
		return vehicleDetails;
	}

	@Override
	public List<Vehicle> viewAllVehicles() {
		return vehicleRepo.findAll();
	}

	@Transactional
	@Override
	public Vehicle updateVehicleDetails(int vehicleId, Vehicle vehicle) {
		vehicleRepo.save(vehicle);
		return vehicle;
	}
	
	@Override
	public Optional<Vehicle> getVehicleById(int vehicleId) {
		return vehicleRepo.findById(vehicleId);
	}
	
	@Override
	public List<Vehicle> getVehicleByUserId(int userId) {
		return vehicleRepo.findByUserId(userId);
	}
	
	@Override
	@Transactional
	public Vehicle deleteVehicle(int vehicleId) {
		Optional<Vehicle> findVehicle = vehicleRepo.findById(vehicleId);
		Vehicle vehicle = null;
		if (findVehicle.isPresent()) {
			vehicle = findVehicle.get();
			vehicleRepo.delete(vehicle);
		} 
		return vehicle;
	}
	
}
