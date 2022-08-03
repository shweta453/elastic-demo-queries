package com.elasticsearch.git.elasticdemoqueries.controller;

import com.elasticsearch.git.elasticdemoqueries.model.RestResponse;
import com.elasticsearch.git.elasticdemoqueries.model.WSMultiIndexResponse;
import com.elasticsearch.git.elasticdemoqueries.service.UserIndexSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserSearchController {

    private final UserIndexSearchService userIndexSearchService;

    //SEARCH BY PHRASE//matchQuery
    //matches if any one of the search keyword is present in the field
    @GetMapping("/search/phrase")
    public ResponseEntity<RestResponse> searchPhrase(@RequestParam("query") String query,
                                                     @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                                                     @RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset){
        return ResponseEntity.ok(userIndexSearchService.searchMatchPhrase(query, offset, limit));
    }

    //WILL SEARCH IN "firstName", "lastName", "uniqueId", "mobileNumber"//multiMatchQuery
    //matches if any one of the search keyword is present in the field
    @GetMapping("/search/multi")
    public ResponseEntity<RestResponse> searchMulti(@RequestParam("query") String query,
                                                    @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                                                    @RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset,
                                                    @RequestParam(value = "prefix_phrase_enabled", defaultValue = "false",required = false) Boolean prefixPhraseEnabled) throws Exception {
        return ResponseEntity.ok(userIndexSearchService.multiSearchQuery(query, offset, limit, prefixPhraseEnabled));
    }

    //SEARCH BY PROFESSION//termQuery
    //The keyword is searched as an exact match
    @GetMapping("/search/keyword/term")
    public ResponseEntity<RestResponse> searchKeywordTerm(@RequestParam("query") String query,
                                                          @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                                                          @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.queryKeywordTerm(query, offset, limit));
    }

    //search by profession//working//termQuery
    @GetMapping("/search/term")
    public ResponseEntity<RestResponse> searchTerm(@RequestParam("query") String query,
                                                   @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                   @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.queryTerm(query, offset, limit));
    }

    //search by profession//working//termsQuery
    @GetMapping("/search/terms")
    public ResponseEntity<RestResponse> searchTerms(@RequestParam("query") List<String> queries,
                                                    @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                    @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.queryTerms(queries, offset, limit));
    }

    //working/matchQuery//AND
    @GetMapping("/search/must/bool")
    public ResponseEntity<RestResponse> searchBoolMust(@RequestParam("profession") String profession,
                                                       @RequestParam("mobileNumber") String mobileNumber,
                                                       @RequestParam("maritalStatus") String maritalStatus,
                                                       @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                                                       @RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.queryBoolWithMust(profession, mobileNumber, maritalStatus, offset, limit));
    }

    //working//matchQuery//OR
    @GetMapping("/search/should/bool")
    public ResponseEntity<RestResponse> searchBoolShould(@RequestParam("profession") String profession,
                                                         @RequestParam("mobileNumber") String mobileNumber,
                                                         @RequestParam("maritalStatus") String maritalStatus,
                                                         @RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
                                                         @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.queryBoolWithShould(profession, mobileNumber, maritalStatus, offset, limit));
    }

    //working
    @GetMapping("/search/wildcard")
    public ResponseEntity<RestResponse> searchBoolShould(@RequestParam("query") String query,
                                                         @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                         @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.wildcardSearch(query, offset, limit));
    }

    //not working
    @GetMapping("/search/regexp")
    public ResponseEntity<RestResponse> searchRegularExpression(@RequestParam("query") String query,
                                                                @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                                @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.regExpSearch(query, offset, limit));
    }

    //searches by name
    @GetMapping("/search/simple")
    public ResponseEntity<RestResponse> searchSimpleQuery(@RequestParam("query") String query,
                                                          @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                          @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.simpleQueryStringSearch(query, offset, limit));
    }

    @GetMapping("/search/income/range")
    public ResponseEntity<RestResponse> searchIncomeRange(@RequestParam("lowerLimit") Integer lowerLimit,
                                                          @RequestParam("upperLimit") Integer upperLimit,
                                                          @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                          @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.searchIncomeRange(lowerLimit, upperLimit, offset, limit));
    }

    @GetMapping("/search/date/range")
    public ResponseEntity<RestResponse> searchDateRange(@RequestParam("fromDate") String fromDate,
                                                        @RequestParam("toDate") String toDate,
                                                        @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                        @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset){
        return ResponseEntity.ok(userIndexSearchService.searchDateRange(fromDate, toDate, offset, limit));
    }

    @GetMapping("/search/geo_distance")
    public ResponseEntity<RestResponse> searchGeoDistance(@RequestParam("lon") Double longitude,
                                                          @RequestParam("lat") Double latitude,
                                                          @RequestParam(value = "limit", defaultValue = "10",required = false) Integer limit,
                                                          @RequestParam(value = "offset", defaultValue = "0",required = false) Integer offset) {
        return ResponseEntity.ok(userIndexSearchService.queryGeographyPoint(longitude, latitude, offset, limit));
    }

    @GetMapping("/search/multi/indices")
    public ResponseEntity<WSMultiIndexResponse> searchMultiIndices(@RequestParam("id") String userId) {
        return ResponseEntity.ok(userIndexSearchService.multiIndexSearch(userId));
    }
}

